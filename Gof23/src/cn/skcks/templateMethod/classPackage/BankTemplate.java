package cn.skcks.templateMethod.classPackage;

public abstract class BankTemplate {
	// 具体方法
	public void takeNumber(){
		System.out.println("取号排队");
	}

	// 要执行的业务
	public abstract void transact();

	public void evaluate(){
		System.out.println("反馈评分");
	}

	// 模板方法
	public final void process(){
		this.takeNumber();

		this.transact();

		this.evaluate();
	}
}
