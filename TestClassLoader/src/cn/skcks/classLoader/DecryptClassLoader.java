package cn.skcks.classLoader;

import com.sun.xml.internal.messaging.saaj.util.ByteOutputStream;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.lang.reflect.Method;
import java.util.Arrays;

/*
	自定义 解密 类加载器
 */
public class DecryptClassLoader extends ClassLoader {
	public static void main(String[] args) {
		CustomFileSystemClassLoader loader = new CustomFileSystemClassLoader(System.getProperty("user.dir"));
		DecryptClassLoader decryptLoader = new DecryptClassLoader(System.getProperty("user.dir"));
		try {
			Class<?> userClass = loader.findClass("cn.skcks.classLoader.bean.User");
			Class<?> userClassEncrypt = decryptLoader.findClass("cn.skcks.classLoader.bean.encrypt.User");

			Object userEncrypt = userClassEncrypt.newInstance();
			Method[] methods = userClassEncrypt.getMethods();
			for(Method method:methods)
			{
				System.out.println(method);
			}

			Method setName = userClassEncrypt.getMethod("setName",String.class);
			setName.invoke(userEncrypt,"时空");
			Method getName = userClassEncrypt.getMethod("getName");
			System.out.println(getName.invoke(userEncrypt));

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	String rootPath;

	public DecryptClassLoader(String rootPath) {
		this.rootPath = rootPath;
	}

	@Override
	protected Class<?> findClass(String name) throws ClassNotFoundException {
		Class<?> c = findLoadedClass(name);

		//  判断是否已被加载过,如果被加载过则直接返回已加载过的类
		//  如果没有则加载新的类
		if (c != null) {
			return c;
		} else {
			try {
				ClassLoader parentLoader = this.getParent();
				c = parentLoader.loadClass(name);
			} catch (Exception e) {
				c = null;
			}

			if (c != null) {
				return c;
			} else {
				byte[] classData = getClassData(name);
				if (classData == null) {
					throw new ClassNotFoundException("类" + name + "未找到");
				} else {
					c = defineClass(name, classData, 0, classData.length);
					return c;
				}
			}
		}
	}

	private byte[] getClassData(String className) {
		String path = rootPath + File.separator + className.replace(".", File.separator) + ".class";

		try (
				InputStream inputStream = new FileInputStream(path);
				ByteOutputStream byteOutputStream = new ByteOutputStream();
		) {
			int tmp;
			while ((tmp = inputStream.read()) != -1) {
				// 取反
				byteOutputStream.write(tmp ^ 0xff);
			}
			byteOutputStream.flush();
//			System.out.println(Arrays.toString(byteOutputStream.toByteArray()));
			return byteOutputStream.toByteArray();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;

	}
}
