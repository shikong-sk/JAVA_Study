package cn.skcks.strategy;

import cn.skcks.strategy.classPackage.Context;
import cn.skcks.strategy.classPackage.OldCustomerMore;
import cn.skcks.strategy.interfacePackage.Strategy;

/*
	策略模式
 */
public class TestStrategy {
	public static void main(String[] args) {
		Strategy strategy = new OldCustomerMore();
		Context context = new Context(strategy);

		context.price(1000);
	}

	/*
		简易实现方法
		算法复杂时 代码量长
		不符合开闭原则
	 */
	public double getPrice(String type,double price)
	{
		switch (type) {
			case "普通客户少量":
				System.out.println("原价");
				break;
			case "普通客户大量":
				System.out.println("九折");
				return price * .9;
			case "老客户少量":
				System.out.println("八五折");
				return price * .85;
			case "老客户大量":
				System.out.println("八折");
				return price * .8;
		}

		return price;
	}
}
