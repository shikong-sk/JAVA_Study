package cn.skcks.strategy.classPackage;

import cn.skcks.strategy.interfacePackage.Strategy;

public class OldCustomerMore implements Strategy {
	@Override
	public double getPrice(double standardPrice) {
		System.out.println("八折");
		return standardPrice * .8;
	}
}
