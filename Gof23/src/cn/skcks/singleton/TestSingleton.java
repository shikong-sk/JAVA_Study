package cn.skcks.singleton;

/*
	单例模式

	饿汉式
 */
public class TestSingleton {
	// 类初始化时 立刻加载这个对象 没有延时加载的优势
	private static TestSingleton instance = new TestSingleton();

	// 私有化构造器
	private TestSingleton() {
	}

	// 没有使用同步 调用效率高
	public static TestSingleton getInstance(){
		return instance;
	}

}
