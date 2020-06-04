package cn.skcks.classLoader;

import com.sun.xml.internal.messaging.saaj.util.ByteOutputStream;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Arrays;

/*
	自定义 文件系统 类加载器
 */
public class CustomFileSystemClassLoader extends ClassLoader {
	private final String rootPath;

	public CustomFileSystemClassLoader(String rootPath) {
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
			try{
				ClassLoader parentLoader = this.getParent();
				c = parentLoader.loadClass(name);
			}catch (Exception e){
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
			int len;
			byte[] buffer = new byte[1024];
			while ((len = inputStream.read(buffer)) != -1)
			{
				byteOutputStream.write(buffer,0,len);
				if(len < buffer.length)
				{
					break;
				}
			}
			byteOutputStream.flush();
			return byteOutputStream.toByteArray();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;

	}
}
