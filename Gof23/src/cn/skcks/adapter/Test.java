package cn.skcks.adapter;

import cn.skcks.adapter.testPackage.Adapted;
import cn.skcks.adapter.testPackage.Adapter;
import cn.skcks.adapter.testPackage.Adapter_2;
import cn.skcks.adapter.testPackage.Target;

/*
	适配器模式

	例：
		java.io.InputStreamReader(InputStream)
		java.io.OutputStreamWriter(OutputStream)

	测试适配器
 */
public class Test {
	public static void main(String[] args) {
		/*
			类适配器
		 */
		// 用户
		Test test = new Test();

		// 需要被适配的对象
		Adapted adapted = new Adapted();

		// 适配器
		Target target = new Adapter();

		// 使用
		System.out.print("类   适配器 => ");
		test.test(target);


		/*
			对象适配器
		 */
		// 用户
		Test test2 = new Test();

		// 需要被适配的对象
		Adapted adapted2 = new Adapted();

		// 适配器
		Target target2 = new Adapter_2(adapted2);

		// 使用
		System.out.print("对象 适配器 => ");
		test2.test(target2);
	}

	private void test(Target target){
		target.handle();
	}
}
