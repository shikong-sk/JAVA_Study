package cn.skcks.orm.utils;

import cn.skcks.orm.bean.ColumnInfo;
import cn.skcks.orm.bean.TableInfo;
import cn.skcks.orm.classPackage.TableManager;

import java.lang.reflect.Method;

/**
 * 封装 反射 操作
 */
public class ReflectUtils {

	/**
	 * 调用 对象 对应 属性 的 get 方法
	 * @param object 需要调用的对象
	 * @param fieldName 需要调用 get方法 的字段名
	 * @return 字段值
	 */
	public static Object invokeGet(Object object, String fieldName) {
//		Class<?> clz = object.getClass();

//		TableInfo tableInfo = TableManager.tableMap.get(object.getClass());
//
//		ColumnInfo primaryKey = tableInfo.getPrimaryKey();

		try {

			// Java 保留关键字 过滤
			String[] javaKeywords = new String[]{"class", "public"};

			for (String keyword : javaKeywords) {
				if (fieldName.equals(keyword)) {
					fieldName = "_" + StringUtils.firstChar2UpperCase(fieldName);
				}
			}

			// 通过反射 调用属性的 get 方法
			Method method = object.getClass().getDeclaredMethod("get" + StringUtils.firstChar2UpperCase(fieldName));

			// 实际执行的 类对象为 object
			return method.invoke(object);
		} catch (Exception e) {
			e.printStackTrace();

			return null;
		}
	}

	/**
	 * 调用 对象 对应 属性 的 set 方法
	 * @param object 需要调用的对象
	 * @param fieldName 需要调用 set方法 的字段名
	 * @param columnValue 要设置的字段值
	 */
	public static void invokeSet(Object object, String fieldName, Object columnValue) {
		try {
			Method method;
			if(columnValue !=null)
			{
				method = object.getClass()
						.getDeclaredMethod("set" + StringUtils.firstChar2UpperCase(fieldName), columnValue.getClass());
			}
			else{
				method = object.getClass()
						.getDeclaredMethod("set" + StringUtils.firstChar2UpperCase(fieldName));
			}
			method.invoke(object, columnValue);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}