package cn.skcks.bridge.classPackage.category;

import cn.skcks.bridge.classPackage.Computer;
import cn.skcks.bridge.interfacePackage.Brand;

public class LaptopBridge extends Computer {
	public LaptopBridge(Brand brand) {
		super(brand);
	}

	@Override
	public void sale() {
		super.sale();
		System.out.println("销售笔记本");
	}
}
