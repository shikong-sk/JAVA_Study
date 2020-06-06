package cn.skcks.factory.simpleFactory;

import cn.skcks.factory.simpleFactory.classPackage.Audi;
import cn.skcks.factory.simpleFactory.classPackage.Byd;
import cn.skcks.factory.simpleFactory.interfacePackage.Car;

/*
	简单工厂模式
 */
public class TestSimpleFactory {
	public static Car createCar(String type)
	{
		if("audi".equals(type))
		{
			return new Audi();
		}
		else if("byd".equals(type))
		{
			return new Byd();
		}
		return null;
	}


}
