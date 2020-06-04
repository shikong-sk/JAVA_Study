package cn.skcks.classLoader;

/*
	类的加载过程
 */

import custom.java.lang.String;

@SuppressWarnings("all")
// 0 Object 所有的类初始化时都会初始化 Object
public class classLoader extends Object{
	// 1
	static{
		System.out.println("静态初始化 cn.skcks.classLoader 类");
	}

	// 2
	public static void main(String[] args) throws Exception {
		System.out.println("调用 main 方法");

		System.out.println("========== 类的被动引用 ==========");
		/*
			被动引用
		 */
		// 调用 final 常量 和 静态方法 不会触发类的初始化
		// 常量会被加载到常量池中
		System.out.println(TestLoader.MAX);
		// 通过数组定义类引用 不会触发类初始化
		TestLoader[] testLoaders = new TestLoader[]{};

		System.out.println("========== 类的主动引用 ==========");

		/*
			主动引用
		 */
		// 调用类的静态成员 除了(final 和 静态方法) 会触发类的初始化
//		System.out.println(TestLoader.intNum);

//		TestLoader testLoader = new TestLoader();

		// 同一个类多次 new 只会静态加载一次
//		TestLoader testLoader2 = new TestLoader();

		// 通过 反射 对类进行 反射调用 会触发类初始化
//		Class.forName("cn.skcks.cn.skcks.classLoader.TestLoader");

		// 当访问一个静态 域(变量) 时,只有真正声明这个 域(变量) 的类才会被初始化
		System.out.println(TestLoaderSon.intNum);
	}
}

class TestLoaderFather{
	// 3
	static {
		System.out.println("静态初始化 父类 对象");
	}
}

class TestLoader extends TestLoaderFather{
	// 4
	public static int intNum = 100; // 静态变量 静态域
	public static final int MAX = 100;

	// 5
	static {
		System.out.println("静态初始化 类 对象");
		intNum = 800;
	}

	// 6
	public TestLoader(){
		System.out.println("创建类对象");
	}
}

class TestLoaderSon extends TestLoader{
	static {
		System.out.println("静态初始化 TestLoaderSon 类 对象");
	}
}

