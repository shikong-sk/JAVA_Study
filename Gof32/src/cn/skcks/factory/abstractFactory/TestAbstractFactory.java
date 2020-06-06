package cn.skcks.factory.abstractFactory;

import cn.skcks.factory.abstractFactory.interfacePackage.CarFactory;
import cn.skcks.factory.abstractFactory.interfacePackage.Engine;
import cn.skcks.factory.abstractFactory.interfacePackage.LowCarFactory;
import cn.skcks.factory.abstractFactory.interfacePackage.LuxuryCarFactory;

/*
	抽象工厂模式
 */
public class TestAbstractFactory {
	public static void main(String[] args) {
		CarFactory luxuryCar = new LuxuryCarFactory();
		Engine luxuryEngine = luxuryCar.createEngine();
		luxuryEngine.run();
		luxuryEngine.start();


		CarFactory lowCar = new LowCarFactory();
		Engine lowEngine = lowCar.createEngine();
		lowEngine.run();
		lowEngine.start();
	}
}
