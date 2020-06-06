package cn.skcks.classLoader;

/*
	线程上下文类 加载器
 */
public class ContextClassLoader {
	public static void main(String[] args) {
		// 默认为 AppClassLoader 系统默认类加载器
		ClassLoader loader = ContextClassLoader.class.getClassLoader();
		System.out.println(loader);

		// 默认为 AppClassLoader 系统默认类加载器
		ClassLoader mainLoader = Thread.currentThread().getContextClassLoader();
		System.out.println(mainLoader);

		// 设置 自定义线程上下文加载器
		Thread.currentThread().setContextClassLoader(new CustomFileSystemClassLoader(System.getProperty("user.dir")));
		System.out.println(Thread.currentThread().getContextClassLoader());

		try {
			// 使用 自定义线程上下文加载器 加载类
			Class<?> userClass = Thread.currentThread().getContextClassLoader().loadClass("cn.skcks.classLoader.bean.User");
			System.out.println(userClass);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
}
