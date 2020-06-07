package cn.skcks.factory.factoryMethod;

import cn.skcks.factory.factoryMethod.classPackage.AudiFactory;
import cn.skcks.factory.factoryMethod.classPackage.BydFactory;
import cn.skcks.factory.factoryMethod.interfacePackage.Car;

/*
	工厂方法模式

	满足 OCP 但结构复杂 工厂方法的工厂类数量随着类的增加而增加

	理论建议使用 工厂方法模式
	实际上更常用简单工厂模式
 */
public class TestFactoryMethod {
	public static void main(String[] args) {
		Car car1 = new AudiFactory().createCar();
		Car car2 = new BydFactory().createCar();

		car1.run();
		car2.run();
	}
}
