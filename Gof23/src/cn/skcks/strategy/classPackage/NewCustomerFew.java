package cn.skcks.strategy.classPackage;

import cn.skcks.strategy.interfacePackage.Strategy;

public class NewCustomerFew implements Strategy {
	@Override
	public double getPrice(double standardPrice) {
		System.out.println("原价");
		return standardPrice;
	}
}
