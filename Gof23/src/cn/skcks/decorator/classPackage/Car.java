package cn.skcks.decorator.classPackage;

import cn.skcks.decorator.interfacePackage.CarInterface;

/*
	具体 构建角色

	真实对象 被装饰对象
 */
public class Car implements CarInterface {
	@Override
	public void move() {
		System.out.println("在地上跑");
	}
}
