package cn.skcks.bridge.classPackage;

import cn.skcks.bridge.interfacePackage.Brand;

public class Dell implements Brand {
	@Override
	public void sale() {
		System.out.println("销售戴尔电脑");
	}
}
