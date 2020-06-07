package cn.skcks.singleton;

import java.io.*;
import java.lang.reflect.Constructor;

/*
	测试 成功 反射 和 反序列化 破解单例模式
 */
public class Test2 {
	public static void main(String[] args) {

		// 懒汉式
		TestSingleton_2 testSingleton2 = TestSingleton_2.getInstance();
		TestSingleton_2 testSingleton2_1 = TestSingleton_2.getInstance();

		System.out.println(testSingleton2);
		System.out.println(testSingleton2_1);

		System.out.println("============== 测试  通过反射 直接调用私有构造器 ==============");
		try {
			Class<?> testSingleton2Clz = Class.forName("cn.skcks.singleton.TestSingleton_2");

			Constructor<?> testSingleton2Constructor = testSingleton2Clz.getDeclaredConstructor();

			// 关闭安全检查 绕过 私有 属性 限制
			testSingleton2Constructor.setAccessible(true);
			Object testSingleton2Class = testSingleton2Constructor.newInstance();

			System.out.println(testSingleton2Class);

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("======================== 反射调用失败 ========================");
		}


		System.out.println();


		// 通过反射调用构造器
		// 懒汉式 防反射
		TestSingleton_6 testSingleton6 = TestSingleton_6.getInstance();
		TestSingleton_6 testSingleton6_1 = TestSingleton_6.getInstance();

		System.out.println(testSingleton6);
		System.out.println(testSingleton6_1);

		System.out.println("============== 测试  通过反射 直接调用私有构造器 ==============");
		try {
			Class<?> testSingleton6Clz = Class.forName("cn.skcks.singleton.TestSingleton_6");

			Constructor<?> testSingleton6Constructor = testSingleton6Clz.getDeclaredConstructor();

			// 关闭安全检查 绕过 私有 属性 限制
			testSingleton6Constructor.setAccessible(true);
			Object testSingleton6Class = testSingleton6Constructor.newInstance();

			System.out.println(testSingleton6Class);

		} catch (Exception e) {
			System.out.println("======================== 反射调用失败 ========================");
		}


		System.out.println();


		System.out.println("============== 测试  通过反序列化构造 新 对象 ==============");
		// 通过反序列化构造对象
		try {

			FileOutputStream fileOutputStream = new FileOutputStream(System.getProperty("user.dir") + File.separator + "TestSingleton_2.txt");
			ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);


			// 写入对象
			objectOutputStream.writeObject(TestSingleton_2.getInstance());

			objectOutputStream.flush();
			objectOutputStream.close();
			fileOutputStream.close();

			// 读取对象
			ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("TestSingleton_2.txt"));
			Object objectTestSingleton_2 = objectInputStream.readObject();
			System.out.println(objectTestSingleton_2);

			if (objectTestSingleton_2 == testSingleton2) {
				System.out.println("=================== 反序列化构造 新 对象 失败 ===================");
			} else {
				System.out.println("=================== 反序列化构造 新 对象 成功 ===================");
			}

		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}


		System.out.println();


		System.out.println("============== 测试  通过反序列化构造 新 对象 ==============");
		try {

			FileOutputStream fileOutputStream = new FileOutputStream(System.getProperty("user.dir") + File.separator + "TestSingleton_6.txt");
			ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);


			// 写入对象
			objectOutputStream.writeObject(TestSingleton_6.getInstance());

			objectOutputStream.flush();
			objectOutputStream.close();
			fileOutputStream.close();

			// 读取对象
			ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("TestSingleton_6.txt"));
			Object objectTestSingleton_6 = objectInputStream.readObject();
			System.out.println(objectTestSingleton_6);

			if (objectTestSingleton_6 == testSingleton6) {
				System.out.println("=================== 反序列化构造 新 对象 失败 ===================");
			} else {
				System.out.println("=================== 反序列化构造 新 对象 成功 ===================");
			}

		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
}
