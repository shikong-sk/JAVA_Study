package cn.skcks.bridge.classPackage.category;

import cn.skcks.bridge.interfacePackage.Computer;

public class Pad implements Computer {
	@Override
	public void sale() {
		System.out.println("销售平板电脑");
	}
}
