package cn.skcks.adapter.testPackage;

/*
	适配器

	类适配器 方式
 */
public class Adapter extends Adapted implements Target{
	@Override
	public void handle() {
		super.request();
	}
}
