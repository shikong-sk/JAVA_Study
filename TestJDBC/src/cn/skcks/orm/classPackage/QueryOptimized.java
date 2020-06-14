package cn.skcks.orm.classPackage;

import cn.skcks.orm.utils.ReflectUtils;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.sql.*;
import java.util.List;

public class QueryOptimized extends QueryAbstract implements Cloneable{

	@Override
	protected Object clone() throws CloneNotSupportedException {
		return super.clone();
	}

	@Override
	public int executeDML(String sql, Object[] params) {
		return super.executeDML(sql, params);
	}

	@Override
	public int insert(Object object) {
		return super.insert(object);
	}

	@Override
	public int delete(Class<?> clz, Object object) {
		return super.delete(clz, object);
	}

	@Override
	public int delete(Object object) {
		return super.delete(object);
	}

	@Override
	public int update(Object object, String[] fields) {
		return super.update(object, fields);
	}

	@Override
	public List<?> queryRows(String sql, Class<?> clz, Object[] params) {
		return super.queryRows(sql, clz, params);
	}

	@Override
	public Object queryRow(String sql, Class<?> clz, Object[] params) {
		return super.queryRow(sql, clz, params);
	}

	@Override
	public Object queryValue(String sql, Object[] params) {
		return super.queryValue(sql, params);
	}

	@Override
	public Number queryNumberValue(String sql, Object[] params) {
		return super.queryNumberValue(sql, params);
	}

	@Override
	public Object queryPaginate(int page, int num) {
		return null;
	}

	public static void main(String[] args) {
		Class<?> studentClz = TableManager.classLoader("ms_student");

		if (studentClz == null) {
			throw new RuntimeException("目标类不存在");
		}

		try {
			Object student = studentClz.newInstance();

			for (Method method : studentClz.getMethods()) {
				if (method.getName().startsWith("set")) {
					if (method.getParameterTypes()[0] == String.class) {
						method.invoke(student, "");
					} else if (method.getParameterTypes()[0] == Date.class) {
						method.invoke(student, new Date(System.currentTimeMillis()));
					} else if (method.getParameterTypes()[0] == Integer.class) {
						method.invoke(student, 0);
					}
				}

			}

			Method setStudentId = studentClz.getMethod("setStudentId", String.class);
			Method setStudentName = studentClz.getMethod("setStudentName", String.class);
			Method setGender = studentClz.getMethod("setGender", String.class);

			setStudentId.invoke(student, "123456");
			setStudentName.invoke(student, "测试");
			setGender.invoke(student, "男");

			System.out.println("添加 " + new QueryOptimized().insert(student) + " 条数据");

			setStudentName.invoke(student, "测试更新");

			System.out.println("更新 " + new QueryOptimized().update(student, new String[]{"studentName"}) + " 条数据");

			System.out.println("删除 " + new QueryOptimized().delete(student) + " 条数据");

			for(Object obj : new QueryOptimized().queryRows("SELECT studentId,studentName FROM ms_student",studentClz,new Object[]{}))
			{
				for(Field field:studentClz.getDeclaredFields())
				{
					Object data = ReflectUtils.invokeGet(obj,field.getName());

					if(data != null)
					{
						System.out.println(field.getName() + " => " + data);
					}

				}
				System.out.println();
			}


//			System.out.println("共 "+ new QueryOptimized().queryNumberValue("SELECT count(*) FROM ms_student",new Object[]{}) +" 条 记录");

			// 使用工厂类
			System.out.println("共 "+ QueryFactory.createQuery().queryNumberValue("SELECT count(*) FROM ms_student",new Object[]{}) +" 条 记录");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}