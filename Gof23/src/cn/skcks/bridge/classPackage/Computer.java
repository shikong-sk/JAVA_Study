package cn.skcks.bridge.classPackage;

import cn.skcks.bridge.interfacePackage.Brand;

public class Computer {
	protected Brand brand;

	public Computer(Brand brand) {
		this.brand = brand;
	}

	public void sale(){
		brand.sale();
	}
}
