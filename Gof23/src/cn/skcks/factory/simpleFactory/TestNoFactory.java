package cn.skcks.factory.simpleFactory;

import cn.skcks.factory.simpleFactory.classPackage.Audi;
import cn.skcks.factory.simpleFactory.classPackage.Byd;
import cn.skcks.factory.simpleFactory.interfacePackage.Car;

/*
	没有 工厂模式 下 实现的方法
 */
public class TestNoFactory {
	// 调用者
	public static void main(String[] args) {
		Car car1 = new Audi();
		Car car2 = new Byd();

		car1.run();
		car2.run();
	}
}
