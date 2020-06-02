package cn.skcks.reflection;

/*
	反射

	java.lang.Class 对象的获取方式

	class、interface、annotation、enum、primitive type、void
 */
public class TestReflection {
	public static void main(String[] args) {
		String path = "cn.skcks.reflection.bean.User";

		try {
//			@SuppressWarnings("rawtypes")
//			Class clz = Class.forName(path);

			// 对象时表示或封装一些数据
			// 当一个类被加载后，JVM 会创建一个对应该类的 Class 对象
			// 类的整个机构信息会存放到相对应的 Class 对象中
			// 在这个 Class 对象中可以看到该类的所有信息
			Class<?> clz = Class.forName(path);

			System.out.println(clz);

			// 同一个类只对应一个 Class 对象
			Class<?> clz2 = Class.forName(path);

			System.out.println(clz.hashCode());
			System.out.println(clz2.hashCode());

			// 获取 Class (反射对象) 的其他方法
			Class<?> strClz = String.class;
			System.out.println(strClz == path.getClass());

			Class<?> intClz = int.class;

			// 同类型的同维数组 均为同一个 Class 与 数组长度无关
			// 同类型不同维数组 为不同的 Class 对象
			int[] intArr = new int[10];
			int[] intArr2 = new int[20];
			int[][] intArr3 = new int[10][10];

			System.out.println(intArr.getClass().hashCode());
			System.out.println(intArr2.getClass().hashCode());
			System.out.println(intArr3.getClass().hashCode());


		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
