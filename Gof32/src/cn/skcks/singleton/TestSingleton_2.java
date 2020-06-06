package cn.skcks.singleton;

import java.io.Serializable;

/*
	单例模式

	懒汉式
 */
public class TestSingleton_2 implements Serializable {
	// 类初始化时 不初始化
	private static TestSingleton_2 instance;

	// 私有化构造器
	private TestSingleton_2() {
	}

	// 使用同步 调用效率低 真正使用的时候才加载
	public static synchronized TestSingleton_2 getInstance(){
		if(instance == null)
		{
			instance = new TestSingleton_2();
		}
		return instance;
	}

}
