package cn.skcks.singleton;

/*
	单例模式

	枚举式
	没有延迟加载
 */
public enum TestSingleton_5 {
	// 枚举元素本身就是单例对象
	INSTANCE;

	// 添加操作方法
	public void singletonMethod(){}

	// 防止反射 和 反序列化
}
