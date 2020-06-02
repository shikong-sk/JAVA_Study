package cn.skcks.annotation;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

/*
    使用反射读取注解信息
 */
public class ReadAnnotation {
	public static void main(String[] args) {
		try {
			@SuppressWarnings("rawtypes")
			Class clz = Class.forName("cn.skcks.annotation.Student");

			Annotation[] annotations = clz.getAnnotations();

			// 获得类的有效注解
			for (Annotation annotation : annotations) {
				System.out.println(annotation);
			}

			// 直接获取相应的注解
			TableAnnotation tableAnnotation = (TableAnnotation) clz.getAnnotation(TableAnnotation.class);
			System.out.println(tableAnnotation);

			// 获取注解的值
			System.out.println(tableAnnotation.value());

			// 获取类成员的注解
			Field field = clz.getDeclaredField("studentName");
			FieldAnnotation studentNameFieldAnnotation = field.getAnnotation(FieldAnnotation.class);

			// 获取注解的值
			System.out.println(
					"fieldName：" + studentNameFieldAnnotation.fieldName() +
					"\tfieldType：" + studentNameFieldAnnotation.fieldType() +
					"\tlength：" + studentNameFieldAnnotation.length()
			);

			// 数据库应用中
			// 可根据获得的信息(例：表名、字段等) 拼接 SQL 语句 并 执行，在数据库中生成相应的数据库表等

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
