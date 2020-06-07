package cn.skcks.singleton;

import java.io.Serializable;

/*
	单例模式

	懒汉式
	防反射 和 反序列化漏洞
 */
public class TestSingleton_6 implements Serializable {
	// 类初始化时 不初始化
	private static TestSingleton_6 instance;

	// 私有化构造器
	private TestSingleton_6() {
		// 防止反射
		if(instance != null)
		{
			throw new RuntimeException("反射绕过 被 阻止");
		}
	}

	// 使用同步 调用效率低 真正使用的时候才加载
	public static synchronized TestSingleton_6 getInstance(){
		if(instance == null)
		{
			instance = new TestSingleton_6();
		}
		return instance;
	}

	// 反序列化时 如果存在 readResolve 方法 则自动调用 readResolve 方法
	// 直接返回 instance 不返回新对象
	private Object readResolve() {
		return instance;
	}
}
