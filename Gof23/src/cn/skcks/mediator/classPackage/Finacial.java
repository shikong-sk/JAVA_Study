package cn.skcks.mediator.classPackage;

import cn.skcks.mediator.interfacePackage.Department;
import cn.skcks.mediator.interfacePackage.Mediator;

public class Finacial implements Department {
	// 上级对象
	private final Mediator mediator;

	public Finacial(Mediator mediator) {
		this.mediator = mediator;
		this.mediator.register("finacial",this);
	}

	@Override
	public void selfAction() {
		System.out.println("沉迷数钱 无法自拔");
	}

	@Override
	public void outAction() {
		System.out.println("向上级请求发放工资");
	}
}
