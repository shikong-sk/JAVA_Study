package cn.skcks.prototype;

import java.io.*;
import java.util.Date;

/*
	原型模式

	克隆对象

	使用 序列化 和 反序列化 实现深克隆
 */
public class TestPrototype_3 {
	public static void main(String[] args) {
		/*
			深克隆
		 */
		Sheep sheep1 = new Sheep("多利", new Date(new Date().getTime() - (1000L * 60 * 60 * 24 * 7)));
		System.out.println(sheep1);
		System.out.println(sheep1.getName());
		System.out.println(sheep1.getBoth());

		System.out.println();

		// 克隆对象 修改值不影响原对象
		try {
			// 使用序列化和反序列化实现深克隆
			// 序列化
			ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
			ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
			objectOutputStream.writeObject(sheep1);
			byte[] bytes = byteArrayOutputStream.toByteArray();

			// 反序列化
			ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bytes);
			ObjectInputStream objectInputStream = new ObjectInputStream(byteArrayInputStream);
			Object obj = objectInputStream.readObject();

			Sheep sheep2 = (Sheep) obj;
			sheep2.setName("少利");

			sheep1.setBoth(new Date(new Date().getTime() - (1000L * 60 * 60 * 24 * 14)));
			System.out.println(sheep2.getBoth());

			/*
				克隆的对象的值 为 对象被克隆时的值的克隆
			 */
			System.out.println();

			System.out.println(sheep2);
			System.out.println(sheep2.getName());
			System.out.println(sheep2.getBoth());

		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
}
