package cn.skcks.factory.simpleFactory.classPackage;

import cn.skcks.factory.simpleFactory.interfacePackage.Car;

public class Byd implements Car {
	@Override
	public void run() {
		System.out.println("Byd 行驶中");
	}
}
