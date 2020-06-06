package cn.skcks.classLoader;

import com.sun.xml.internal.messaging.saaj.util.ByteOutputStream;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

/*
	自定义 网络 类加载器
 */
public class CustomNetClassLoader extends ClassLoader {
	private final String rootUrl;

	public CustomNetClassLoader(String rootUrl) {
		this.rootUrl = rootUrl;
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
		String path = rootUrl + File.separator + className.replace(".", File.separator) + ".class";
		try {
			URL url = new URL(path);
			try (
					InputStream inputStream = url.openStream();
					ByteOutputStream byteOutputStream = new ByteOutputStream();
			) {
				int len;
				byte[] buffer = new byte[1024];
				while ((len = inputStream.read(buffer)) != -1) {
					byteOutputStream.write(buffer, 0, len);
					if (len < buffer.length) {
						break;
					}
				}
				byteOutputStream.flush();
				return byteOutputStream.toByteArray();

			} catch (Exception e) {
				e.printStackTrace();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;

	}
}
