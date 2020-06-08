package cn.skcks.strategy.classPackage;

import cn.skcks.strategy.interfacePackage.Strategy;

public class OldCustomerFew implements Strategy {
	@Override
	public double getPrice(double standardPrice) {
		System.out.println("八五折");
		return standardPrice * .85;
	}
}
