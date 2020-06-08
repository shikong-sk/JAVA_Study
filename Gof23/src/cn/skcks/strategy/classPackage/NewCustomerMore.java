package cn.skcks.strategy.classPackage;

import cn.skcks.strategy.interfacePackage.Strategy;

public class NewCustomerMore implements Strategy {
	@Override
	public double getPrice(double standardPrice) {
		System.out.println("九折");
		return standardPrice * .9;
	}
}
