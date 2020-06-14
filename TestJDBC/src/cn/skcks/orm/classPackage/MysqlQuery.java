package cn.skcks.orm.classPackage;

import cn.skcks.orm.bean.ColumnInfo;
import cn.skcks.orm.bean.TableInfo;
import cn.skcks.orm.interfacePackage.Query;
import cn.skcks.orm.utils.JDBCUtil;
import cn.skcks.orm.utils.JavaFileUtils;
import cn.skcks.orm.utils.ReflectUtils;
import cn.skcks.orm.utils.StringUtils;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;

public class MysqlQuery implements Query {
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

			JDBCUtil.handleParams(preparedStatement,params);

			num = preparedStatement.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DbManager.close(connection, preparedStatement);
		}

		return num;
	}

	@Override
	public void insert(Object object) {
		Class<?> clz = object.getClass();

		TableInfo tableInfo = TableManager.tableMap.get(clz);

		Field[] fields = clz.getDeclaredFields();

		for(Field field:fields)
		{
			String fieldName = field.getName();
			Object fieldValue = ReflectUtils.invokeGet(object,fieldName);

			if (fieldValue != null){

			}
		}
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
	public void delete(Object object) {
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

		delete(object.getClass(), primaryKeyValue);
	}

	@Override
	public int update(Object object, String[] fields) {
		return 0;
	}

	@Override
	public List<?> queryRows(String sql, Class<?> clz, Object[] params) {
		return null;
	}

	@Override
	public Object queryRow(String sql, Class<?> clz, Object[] params) {
		return null;
	}

	@Override
	public Object queryValue(String sql, Object[] params) {
		return null;
	}

	@Override
	public Number queryNumberValue(String sql, Object[] params) {
		return null;
	}

	public static void main(String[] args) {
		Class<?> studentClz = TableManager.classLoader("ms_student");

		if(studentClz == null)
		{
			throw new RuntimeException("目标类不存在");
		}

		try {
			Object student = studentClz.newInstance();

			Method setStudentId = studentClz.getMethod("setStudentId",String.class);

			setStudentId.invoke(student,"123456");

			new MysqlQuery().delete(student);

		} catch (InstantiationException | IllegalAccessException | NoSuchMethodException | InvocationTargetException e) {
			e.printStackTrace();
		}
	}
}