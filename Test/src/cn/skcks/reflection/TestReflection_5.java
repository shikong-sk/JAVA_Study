package cn.skcks.reflection;

import cn.skcks.reflection.bean.User;

import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Map;

/*
	通过反射获取泛型信息
 */
public class TestReflection_5 {
	public static void main(String[] args) {
		try {

			System.out.println("方法 参数 泛型信息：");
			// 获得指定方法 的 参数泛型信息
			Method test1 = TestReflection_5.class.getDeclaredMethod("test1", Map.class, List.class);
			// 获取泛型参数 的 类型
			Type[] type = test1.getGenericParameterTypes();
			for (Type paramType : type) {
				System.out.println(paramType);
				// 判断是否为泛型参数
				if (paramType instanceof ParameterizedType) {
					// 获取实际的参数类型
					Type[] genericTypes = ((ParameterizedType) paramType).getActualTypeArguments();
					for (Type genericType : genericTypes) {
						System.out.println("\t" + genericType);
					}
				}
			}

			System.out.println("\n方法 返回值 泛型信息：");
			// 获得指定方法 的 参数泛型信息
			Method test2 = TestReflection_5.class.getDeclaredMethod("test2");
			// 获取泛型参数 的 类型
			Type type2 = test2.getGenericReturnType();

			System.out.println(type2);
			// 判断是否为泛型参数
			if (type2 instanceof ParameterizedType) {
				// 获取实际的参数类型
				Type[] genericTypes = ((ParameterizedType) type2).getActualTypeArguments();
				for (Type genericType : genericTypes) {
					System.out.println("\t" + genericType);
				}
			}


		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@SuppressWarnings("unused")
	// 泛型中的 ? 代表所有类型
	public void test1(Map<Integer, ?> map, List<User> userList) {
		System.out.println("test1");
	}

	@SuppressWarnings("unused")
	public Map<Integer, User> test2() {
		System.out.println("test2()");
		return null;
	}
}
