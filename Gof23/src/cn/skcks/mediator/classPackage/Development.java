package cn.skcks.mediator.classPackage;

import cn.skcks.mediator.interfacePackage.Department;
import cn.skcks.mediator.interfacePackage.Mediator;

public class Development implements Department {
	// 上级对象
	private final Mediator mediator;

	public Development(Mediator mediator) {
		this.mediator = mediator;
		this.mediator.register("development",this);
	}

	@Override
	public void selfAction() {
		System.out.println("沉迷开发 无法自拔");
	}

	@Override
	public void outAction() {
		System.out.println("向上级请求开发资金");
	}
}
