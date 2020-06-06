package cn.skcks.classLoader;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

/*
	类 加密器
 */
public class EncryptClass {

	public static void encrypt(String src, String dest) {
		encrypt(new File(src), new File(dest));
	}

	public static void encrypt(File src, File dest) {
		try (
				FileInputStream fileInputStream = new FileInputStream(src);
				FileOutputStream outputStream = new FileOutputStream(dest)
		) {
			int tmp;
			while ((tmp = fileInputStream.read()) != -1) {
				// 取反
				outputStream.write(tmp ^ 0xff);
			}
			outputStream.flush();


		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		String className = "cn.skcks.classLoader.bean.encrypt.User";
		File classFile = new File(System.getProperty("user.dir") + File.separator + className.replace(".", File.separator) + ".class");
		File encryptClassFile = new File(System.getProperty("user.dir") + File.separator + className.replace(".", File.separator) + ".encrypt.class");
		encrypt(classFile, encryptClassFile);
		classFile.delete();
		encryptClassFile.renameTo(classFile);
	}

}
