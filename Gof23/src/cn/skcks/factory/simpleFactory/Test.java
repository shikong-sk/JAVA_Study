package cn.skcks.factory.simpleFactory;

import cn.skcks.factory.simpleFactory.classPackage.Audi;
import cn.skcks.factory.simpleFactory.classPackage.Byd;
import cn.skcks.factory.simpleFactory.interfacePackage.Car;

/*
	简单工厂测试
 */
public class Test {
	public static void main(String[] args) {
		// 没有 工厂模式 下 实现的方法
		Car car1 = new Audi();
		Car car2 = new Byd();

		car1.run();
		car2.run();

		// 简单工厂模式
		Car car3 = TestSimpleFactory.createCar("audi");
		Car car4 = TestSimpleFactory.createCar("byd");

		assert car3 != null;
		car3.run();
		assert car4 != null;
		car4.run();

		// 简单工厂模式 2
		Car car5 = TestSimpleFactory_2.createAudi();
		Car car6 = TestSimpleFactory_2.createByd();

		car5.run();
		car6.run();
	}
}
