package cn.skcks.mediator;

import cn.skcks.mediator.classPackage.Development;
import cn.skcks.mediator.classPackage.Finacial;
import cn.skcks.mediator.classPackage.Market;
import cn.skcks.mediator.classPackage.President;
import cn.skcks.mediator.interfacePackage.Mediator;

// 中介者模式
public class Test {
	public static void main(String[] args) {
		Mediator mediator = new President();

		Market market = new Market(mediator);
		Development development = new Development(mediator);
		Finacial finacial = new Finacial(mediator);

		market.selfAction();
		development.selfAction();
		finacial.selfAction();

		// 通过 mediator 间接 调用 finacial
		market.outAction();
	}
}
