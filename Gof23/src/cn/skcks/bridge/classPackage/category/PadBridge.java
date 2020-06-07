package cn.skcks.bridge.classPackage.category;

import cn.skcks.bridge.classPackage.Computer;
import cn.skcks.bridge.interfacePackage.Brand;

public class PadBridge extends Computer {
	public PadBridge(Brand brand) {
		super(brand);
	}

	@Override
	public void sale() {
		super.sale();
		System.out.println("销售平板电脑");
	}
}
