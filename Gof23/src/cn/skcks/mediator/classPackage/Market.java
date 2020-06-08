package cn.skcks.mediator.classPackage;

import cn.skcks.mediator.interfacePackage.Department;
import cn.skcks.mediator.interfacePackage.Mediator;

public class Market implements Department {
	// 上级对象
	private final Mediator mediator;

	public Market(Mediator mediator) {
		this.mediator = mediator;
		this.mediator.register("market",this);
	}

	@Override
	public void selfAction() {
		System.out.println("沉迷跑路 无法自拔");
	}

	@Override
	public void outAction() {
		System.out.println("向上级申请资金");
		mediator.command("finacial");
	}
}
