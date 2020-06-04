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
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
