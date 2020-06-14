package cn.skcks.orm.classPackage;

import cn.skcks.orm.bean.ColumnInfo;
import cn.skcks.orm.bean.TableInfo;
import cn.skcks.orm.interfacePackage.CallBack;
import cn.skcks.orm.interfacePackage.Query;
import cn.skcks.orm.utils.JDBCUtil;
import cn.skcks.orm.utils.ReflectUtils;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;
import java.util.List;

public abstract class QueryAbstract implements Query {

	// 模板方法 封装操作 可重用
	public Object executeQueryTemplate(String sql, Class<?> clz, Object[] params, CallBack callBack) {
		Connection connection = DbManager.getConnection();

		if (connection == null) {
			throw new RuntimeException("数据库连接失败");
		}

		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;


		try {
			preparedStatement = connection.prepareStatement(sql);

			JDBCUtil.handleParams(preparedStatement, params);

			resultSet = preparedStatement.executeQuery();

			return callBack.doExecute(connection, preparedStatement, resultSet);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DbManager.close(connection, preparedStatement, resultSet);
		}

		return null;

	}


	/*
		执行 SQL DML 语句
	 */
	@Override
	public int executeDML(String sql, Object[] params) {
		Connection connection = DbManager.getConnection();

		if (connection == null) {
			throw new RuntimeException("数据库连接失败");
		}

		int num = 0;

		PreparedStatement preparedStatement = null;

		try {
			preparedStatement = connection.prepareStatement(sql);

			JDBCUtil.handleParams(preparedStatement, params);

			num = preparedStatement.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DbManager.close(connection, preparedStatement);
		}

		return num;
	}

	@Override
	public int insert(Object object) {
		Class<?> clz = object.getClass();

		TableInfo tableInfo = TableManager.tableMap.get(clz);

		Field[] fields = clz.getDeclaredFields();

		StringBuilder sqlBuilder = new StringBuilder();

		List<Object> params = new ArrayList<>();

		sqlBuilder.append("INSERT INTO ").append(tableInfo.getTable()).append("(");

		for (Field field : fields) {
			String fieldName = field.getName();
			Object fieldValue = ReflectUtils.invokeGet(object, fieldName);

			if (fieldName.startsWith("_")) {
				fieldName = fieldName.substring(1, 2).toLowerCase() + fieldName.substring(2);
			}

			if (fieldValue != null) {
				sqlBuilder.append("`").append(fieldName).append("`,");
				params.add(fieldValue);
			}
		}

		sqlBuilder.setCharAt(sqlBuilder.length() - 1, ')');

		sqlBuilder.append(" VALUES (");

		for (int i = 0; i < params.size(); i++) {
			sqlBuilder.append("?,");
		}

		sqlBuilder.setCharAt(sqlBuilder.length() - 1, ')');

		return executeDML(sqlBuilder.toString(), params.toArray());
	}

	@Override
	public int delete(Class<?> clz, Object object) {

		// 根据 表 Class 对象 查找 TableInfo
		TableInfo tableInfo = TableManager.tableMap.get(clz);

		// 获取主键信息
		ColumnInfo primaryKey = tableInfo.getPrimaryKey();

		String sql = "DELETE FROM " + tableInfo.getTable() + " WHERE " + primaryKey.getField() + " = ?";

		return executeDML(sql, new Object[]{object});
	}

	@Override
	public int delete(Object object) {
//		Class<?> clz = object.getClass();

		TableInfo tableInfo = TableManager.tableMap.get(object.getClass());

		ColumnInfo primaryKey = tableInfo.getPrimaryKey();
//
//		try {
//			// 通过反射 调用属性的 get 方法
//			Method method = clz.getMethod("get" + StringUtils.firstChar2UpperCase(primaryKey.getField()));
//			Object primaryKeyValue = method.invoke(object);
//
//			delete(clz,primaryKeyValue);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}

		Object primaryKeyValue = ReflectUtils.invokeGet(object, primaryKey.getField());

		return delete(object.getClass(), primaryKeyValue);
	}

	@Override
	public int update(Object object, String[] fields) {
		Class<?> clz = object.getClass();

		List<Object> params = new ArrayList<>();
		TableInfo tableInfo = TableManager.tableMap.get(clz);

		// 获取主键
		ColumnInfo primaryKey = tableInfo.getPrimaryKey();

		StringBuilder sqlBuilder = new StringBuilder();

		sqlBuilder.append("UPDATE ").append(tableInfo.getTable()).append(" SET ");

		for (String field : fields) {
			Object fieldValue = ReflectUtils.invokeGet(object, field);

			params.add(fieldValue);
			sqlBuilder.append(field).append("=?,");
		}

		sqlBuilder.setCharAt(sqlBuilder.length() - 1, ' ');

		sqlBuilder.append(" WHERE ");

		sqlBuilder.append(primaryKey.getField()).append("=?");

		params.add(ReflectUtils.invokeGet(object, primaryKey.getField()));

		return executeDML(sqlBuilder.toString(), params.toArray());
	}

	@Override
	public List<?> queryRows(final String sql, final Class<?> clz, final Object[] params) {
//		Connection connection = DbManager.getConnection();
//		if (connection == null) {
//			throw new RuntimeException("数据库连接失败");
//		}
//
//		List<Object> resList = new ArrayList<>();
//
//		PreparedStatement preparedStatement = null;
//
//		ResultSet resultSet = null;
//
//		try {
//			preparedStatement = connection.prepareStatement(sql);
//
//			JDBCUtil.handleParams(preparedStatement, params);
//
//			resultSet = preparedStatement.executeQuery();
//
//			ResultSetMetaData resultSetMetaData = resultSet.getMetaData();
//
//			// 行
//			while (resultSet.next()) {
//				Object rowObj = clz.newInstance();
//
//				// 列
//				for (int i = 0; i < resultSetMetaData.getColumnCount(); i++) {
//					String columnName = resultSetMetaData.getColumnName(i + 1);
//					Object columnValue = resultSet.getObject(i + 1);
//
//					ReflectUtils.invokeSet(rowObj, columnName, columnValue);
//				}
//
//				resList.add(rowObj);
//			}
//
//		} catch (Exception e) {
//			e.printStackTrace();
//		} finally {
//			DbManager.close(connection, preparedStatement, resultSet);
//		}

		return (List<?>) executeQueryTemplate(sql, clz, params, new CallBack() {
			@Override
			public Object doExecute(Connection connection, PreparedStatement preparedStatement, ResultSet resultSet) {
				List<Object> resList = new ArrayList<>();
				try {
					ResultSetMetaData resultSetMetaData = resultSet.getMetaData();

					// 行
					while (resultSet.next()) {
						Object rowObj = clz.newInstance();

						// 列
						for (int i = 0; i < resultSetMetaData.getColumnCount(); i++) {
							String columnName = resultSetMetaData.getColumnName(i + 1);
							Object columnValue = resultSet.getObject(i + 1);

							ReflectUtils.invokeSet(rowObj, columnName, columnValue);
						}

						resList.add(rowObj);
					}

				} catch (Exception e) {
					e.printStackTrace();
				}

				return resList;
			}
		});


	}

	@Override
	public Object queryRow(String sql, Class<?> clz, Object[] params) {
		List<?> list = queryRows(sql, clz, params);
		return (list == null || list.size() != 1) ? null : list.get(0);
	}

	@Override
	public Object queryValue(String sql, Object[] params) {
//		Connection connection = DbManager.getConnection();
//		if (connection == null) {
//			throw new RuntimeException("数据库连接失败");
//		}
//
//		Object value = null;
//
//		PreparedStatement preparedStatement = null;
//
//		ResultSet resultSet = null;
//
//		try {
//			preparedStatement = connection.prepareStatement(sql);
//
//			resultSet = preparedStatement.executeQuery();
//
//			while (resultSet.next()) {
//				value = resultSet.getObject(1);
//			}
//
//		} catch (Exception e) {
//			e.printStackTrace();
//		} finally {
//			DbManager.close(connection, preparedStatement, resultSet);
//		}
		return executeQueryTemplate(sql, null, params, new CallBack() {
			@Override
			public Object doExecute(Connection connection, PreparedStatement preparedStatement, ResultSet resultSet) {
				try {
					Object value = null;

					while (resultSet.next()) {
						value = resultSet.getObject(1);
					}

					return value;
				} catch (Exception e) {
					e.printStackTrace();
					return null;
				}

			}
		});

	}

	@Override
	public Number queryNumberValue(String sql, Object[] params) {
		return (Number) queryValue(sql, params);
	}

	public abstract Object queryPaginate(int page, int num);
}
