package cn.skcks.reflection;

import java.util.Arrays;

/*
	应用反射的 API,获取类的信息

	类名、属性、方法、构造器等
 */
class TestReflection_2 {
	public static void main(String[] args) {
		try {

			String path = "cn.skcks.reflection.bean.User";

			Class<?> clz = Class.forName(path);

			System.out.println("类 信息：");
			// 获取完整类名 包名 + 类名
			System.out.println(clz.getName());
			// 获取类名 类名
			System.out.println(clz.getSimpleName());

			System.out.println("\n类 属性 信息：");
			// 获取属性信息
			// 获取所有 类成员 (只能获取 public 属性的 field)
			System.out.println(Arrays.toString(clz.getFields()));
			// 获取所有 类成员 所有类型的 field
			System.out.println(Arrays.toString(clz.getDeclaredFields()));
			// 获取指定 成员
			System.out.println(clz.getDeclaredField("name"));

			System.out.println("\n类 方法 信息：");
			// 获取方法信息
			// 获取所有 方法 (只能获取 public 属性的方法)
			System.out.println(Arrays.toString(clz.getMethods()));
			// 获取所有 方法 所有类型的方法
			System.out.println(Arrays.toString(clz.getDeclaredMethods()));
			// 获取指定 方法
			System.out.println(clz.getMethod("getAge"));
			// 如果方法有参数，则必须指定对应参数所对应的 Class 对象
			System.out.println(clz.getMethod("setName", String.class));

			// 获取构造器
			System.out.println("\n类 构造器 信息：");
			// 获取所有 构造器 (只能获取 public 属性的构造器)
			System.out.println(Arrays.toString(clz.getConstructors()));
			// 获取所有 构造器 所有类型的构造器
			System.out.println(Arrays.toString(clz.getDeclaredConstructors()));
			// 获取指定 构造器
			System.out.println(clz.getConstructor());
			// 如果构造器有参数，则必须指定对应参数所对应的 Class 对象
			System.out.println(clz.getDeclaredConstructor(int.class,String.class,int.class));

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}