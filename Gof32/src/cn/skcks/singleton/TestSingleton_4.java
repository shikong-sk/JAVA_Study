package cn.skcks.singleton;

/*
	单例模式

	静态内部类式
 */
public class TestSingleton_4 {
	// 外部类没有 static 属性，不会像饿汉式一样立即加载对象

	private TestSingleton_4(){}

	// 只有真正调用 getInstance 时才会加载静态内部类
	public static TestSingleton_4 getInstance(){
		return SingletonClassInstance.instance;
	}

	private static class SingletonClassInstance{
		// static final 类型 保证内存中只有一个示例存在 且只能被赋值一次 保证线程安全
		private static final TestSingleton_4 instance = new TestSingleton_4();
	}
	// 兼具 延迟加载 效率高 的优势
}
