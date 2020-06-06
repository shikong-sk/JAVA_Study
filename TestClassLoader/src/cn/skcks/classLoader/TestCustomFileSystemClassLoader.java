package cn.skcks.classLoader;

/*
	测试 自定义 文件系统 类加载器
 */
public class TestCustomFileSystemClassLoader {
	public static void main(String[] args) {
		System.out.println(System.getProperty("user.dir"));
		CustomFileSystemClassLoader loader = new CustomFileSystemClassLoader(System.getProperty("user.dir"));

		try {
			Class<?> userClass = loader.findClass("cn.skcks.classLoader.bean.User");
			Class<?> userClass2 = loader.findClass("cn.skcks.classLoader.bean.User");

			CustomFileSystemClassLoader loader2 = new CustomFileSystemClassLoader(System.getProperty("user.dir"));
			Class<?> userClass3 = loader2.findClass("cn.skcks.classLoader.bean.User");

			// 同一个加载器加载同一个类 多次 返回的是同一个对象
			System.out.println(userClass.hashCode());
			System.out.println(userClass2.hashCode());
			// 不同加载器加载同一个类 返回的是另外一个对象
			System.out.println(userClass3.hashCode());

			Class<?> stringClass = loader2.findClass("java.lang.String");
			Class<?> class1 = loader2.findClass("cn.skcks.classLoader.classLoader");

			// userClass3 由 自定义 类加载器 cn.skcks.classLoader.CustomFileSystemClassLoader 加载
			System.out.println(userClass3.getClassLoader());
			// java.lang.String 由 引导类加载器 加载
			System.out.println(stringClass.getClassLoader());
			// 系统 默认类加载器 加载
			System.out.println(class1.getClassLoader());



		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
