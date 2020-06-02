package cn.skcks.reflection;

import cn.skcks.reflection.bean.User;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

/*
	测试 反射 运行速度
 */
public class TestReflection_4 {

	public static void main(String[] args) {
		new Thread(TestReflection_4::test1).start();
		new Thread(TestReflection_4::test2).start();
		new Thread(TestReflection_4::test3).start();
	}

	static public void test1(){
		User user = new User();

		long startTime = System.currentTimeMillis();

		for (int i = 0; i < 1000000000L; i++) {
			user.getName();
		}

		long endTime = System.currentTimeMillis();

		System.out.println("普通方法调用 耗时:" + (endTime - startTime)+"ms");
	}

	static public void test2(){
		try {

			@SuppressWarnings("unchecked")
			Class<User> userClass = (Class<User>) Class.forName("cn.skcks.reflection.bean.User");

			Constructor<User> userConstructor = userClass.getConstructor();

			User user = userConstructor.newInstance();
			Method getName = userClass.getDeclaredMethod("getName");

			long startTime = System.currentTimeMillis();

			for (int i = 0; i < 1000000000L; i++) {
				getName.invoke(user);
			}

			long endTime = System.currentTimeMillis();

			System.out.println("反射方法调用 耗时:" + (endTime - startTime)+"ms");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	static public void test3(){
		try {

			@SuppressWarnings("unchecked")
			Class<User> userClass = (Class<User>) Class.forName("cn.skcks.reflection.bean.User");
			Method getName = userClass.getDeclaredMethod("getName");

			Constructor<User> userConstructor = userClass.getConstructor();
			User user = userConstructor.newInstance();

			// 禁用安全检查
			getName.setAccessible(true);

			long startTime = System.currentTimeMillis();

			for (int i = 0; i < 1000000000L; i++) {
				getName.invoke(user);
			}

			long endTime = System.currentTimeMillis();

			System.out.println("反射方法调用(禁用安全检查) 耗时:" + (endTime - startTime)+"ms");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
