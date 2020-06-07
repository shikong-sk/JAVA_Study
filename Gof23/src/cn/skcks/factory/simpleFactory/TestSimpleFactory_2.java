package cn.skcks.factory.simpleFactory;

import cn.skcks.factory.simpleFactory.classPackage.Audi;
import cn.skcks.factory.simpleFactory.classPackage.Byd;
import cn.skcks.factory.simpleFactory.interfacePackage.Car;

/*
	简单工厂模式

	静态工厂模式

	不修改代码无法扩展
 */
public class TestSimpleFactory_2 {
	public static Car createAudi()
	{
		return new Audi();
	}

	public static Car createByd()
	{
		return new Byd();
	}

}
