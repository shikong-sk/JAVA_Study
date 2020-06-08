package cn.skcks.strategy.classPackage;

import cn.skcks.strategy.interfacePackage.Strategy;

/*
	负责与具体的 策略类 交互

	将算法与客户端调用分离
 */
public class Context {
	// 当前算法对象
	private Strategy strategy;

	// 构造器注入
	public Context(Strategy strategy) {
		this.strategy = strategy;
	}

	// set 方法注入
	public void setStrategy(Strategy strategy) {
		this.strategy = strategy;
	}

	public void price(double price)
	{
		System.out.println(strategy.getPrice(price));
	}
}
