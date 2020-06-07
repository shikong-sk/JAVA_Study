package cn.skcks.factory.factoryMethod.classPackage;

import cn.skcks.factory.factoryMethod.interfacePackage.Car;

public class Audi implements Car {
	@Override
	public void run() {
		System.out.println("Audi 行驶中");
	}
}
