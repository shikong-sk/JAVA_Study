package cn.skcks.javassist;

import javassist.ClassPool;
import javassist.CtClass;
import javassist.NotFoundException;

import java.util.Arrays;

/*
	测试 javassist API
 */
public class Javassist_2 {
	public static void main(String[] args) {
		try {
			// 处理类的基本用法
			ClassPool classPool = ClassPool.getDefault();
			CtClass userClass = classPool.get("cn.skcks.javassist.bean.User");

			// 获取字节码
			byte[] userClassBytes = userClass.toBytecode();
			System.out.println(Arrays.toString(userClassBytes));

			// 获取类名
			System.out.println(userClass.getName());
			// 获取简要类名
			System.out.println(userClass.getSimpleName());
			// 获取父类
			System.out.println(userClass.getSuperclass());
			// 获取接口
			System.out.println(Arrays.toString(userClass.getInterfaces()));


		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
