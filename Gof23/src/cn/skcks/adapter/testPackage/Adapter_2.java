package cn.skcks.adapter.testPackage;

/*
	适配器

	对象适配器 方式
	使用 组合 的方式 与 被适配对象整合
 */
public class Adapter_2 implements Target{
	private final Adapted adapted;

	public Adapter_2(Adapted adapted) {
		this.adapted = adapted;
	}

	@Override
	public void handle() {
		adapted.request();
	}
}
