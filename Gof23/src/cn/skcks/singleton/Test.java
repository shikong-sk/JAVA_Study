package cn.skcks.singleton;

import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;public class Test {
	public static void main(String[] args) {
		// 饿汉式
		TestSingleton testSingleton = TestSingleton.getInstance();
		TestSingleton testSingleton_1 = TestSingleton.getInstance();

		System.out.println(testSingleton);
		System.out.println(testSingleton_1);

		// 懒汉式
		TestSingleton_2 testSingleton2 = TestSingleton_2.getInstance();
		TestSingleton_2 testSingleton2_1 = TestSingleton_2.getInstance();

		System.out.println(testSingleton2);
		System.out.println(testSingleton2_1);

		// 双重检测锁式
		TestSingleton_3 testSingleton3 = TestSingleton_3.getInstance();
		TestSingleton_3 testSingleton3_1 = TestSingleton_3.getInstance();

		System.out.println(testSingleton3);
		System.out.println(testSingleton3_1);

		// 静态内部类式
		TestSingleton_4 testSingleton4 = TestSingleton_4.getInstance();
		TestSingleton_4 testSingleton4_1 = TestSingleton_4.getInstance();

		System.out.println(testSingleton4);
		System.out.println(testSingleton4_1);

		// 枚举式
		System.out.println(TestSingleton_5.INSTANCE.hashCode());
		System.out.println(TestSingleton_5.INSTANCE.hashCode());
	}
}
