package cn.skcks.classLoader;


/*
	类加载器的代理模式

	代理模式
	双亲委派
 */
public class classLoader2 {
	public static void main(String[] args) {
		System.out.println(ClassLoader.getSystemClassLoader());
		System.out.println(ClassLoader.getSystemClassLoader().getParent());
		System.out.println(ClassLoader.getSystemClassLoader().getParent().getParent());

		System.out.println(System.getProperty("java.class.path"));

		String string = "string";
		System.out.println(string);
		// 双亲委派机制 优先调用父类加载器 确保安全性
		System.out.println(string.getClass().getClassLoader());
	}
}
