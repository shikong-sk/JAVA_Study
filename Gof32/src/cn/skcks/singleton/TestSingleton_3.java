package cn.skcks.singleton;

/*
	单例模式

	双重检测锁式

	由于编译器优化 和 JVM 底层内部原因 不建议使用
 */
public class TestSingleton_3 {
	private static TestSingleton_3 instance;

	private TestSingleton_3() {
	}

	public static TestSingleton_3 getInstance(){
		if(instance == null)
		{
			TestSingleton_3 tmp;
			synchronized (TestSingleton_3.class){
				tmp = instance;
				synchronized (TestSingleton_3.class)
				{
					if(tmp == null)
					{
						tmp = new TestSingleton_3();
					}
				}
				instance = tmp;
			}
		}
		return instance;
	}
}
