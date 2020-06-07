package cn.skcks.bridge.classPackage;

import cn.skcks.bridge.interfacePackage.Brand;

public class Lenovo implements Brand {
	@Override
	public void sale() {
		System.out.println("销售联想电脑");
	}
}
