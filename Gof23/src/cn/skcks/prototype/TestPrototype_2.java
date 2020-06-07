package cn.skcks.prototype;

import java.util.Date;

/*
	原型模式

	克隆对象
 */
public class TestPrototype_2 {
	public static void main(String[] args) {
		/*
			深克隆
		 */
		Sheep2 sheep1 = new Sheep2("多利",new Date(new Date().getTime() - (1000L * 60 * 60 * 24 * 7)));
		System.out.println(sheep1);
		System.out.println(sheep1.getName());
		System.out.println(sheep1.getBoth());

		System.out.println();

		// 克隆对象 修改值不影响原对象
		try {
			Sheep2 sheep2 = (Sheep2) sheep1.clone();
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

		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
	}
}
