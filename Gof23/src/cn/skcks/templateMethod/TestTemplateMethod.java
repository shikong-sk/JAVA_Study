package cn.skcks.templateMethod;

import cn.skcks.templateMethod.classPackage.BankTemplate;

/*
	模板方法模式
 */
public class TestTemplateMethod {
	public static void main(String[] args) {
		BankTemplate bankTemplate = new GetMoney();
		bankTemplate.process();

		System.out.println();

		// 匿名内部类
		BankTemplate bankTemplate2 = new BankTemplate() {
			@Override
			public void transact() {
				System.out.println("存款");
			}
		};

		bankTemplate2.process();
	}
}

class GetMoney extends BankTemplate{
	@Override
	public void transact() {
		System.out.println("取款");
	}
}