package cn.skcks.factory.simpleFactory.classPackage;

import cn.skcks.factory.simpleFactory.interfacePackage.Car;

public class Audi implements Car {
	@Override
	public void run() {
		System.out.println("Audi 行驶中");
	}
}
