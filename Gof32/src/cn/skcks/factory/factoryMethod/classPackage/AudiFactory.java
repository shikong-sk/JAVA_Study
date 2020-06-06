package cn.skcks.factory.factoryMethod.classPackage;

import cn.skcks.factory.factoryMethod.interfacePackage.Car;
import cn.skcks.factory.factoryMethod.interfacePackage.CarFactory;

public class AudiFactory implements CarFactory {
	@Override
	public Car createCar() {
		return new Audi();
	}
}
