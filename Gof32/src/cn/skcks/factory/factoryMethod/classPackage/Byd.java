package cn.skcks.factory.factoryMethod.classPackage;

import cn.skcks.factory.factoryMethod.interfacePackage.Car;

public class Byd implements Car {
	@Override
	public void run() {
		System.out.println("Byd 行驶中");
	}
}
