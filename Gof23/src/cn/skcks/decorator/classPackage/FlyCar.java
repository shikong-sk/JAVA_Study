package cn.skcks.decorator.classPackage;

import cn.skcks.decorator.interfacePackage.CarInterface;

/*
	ConcreteDecorator
	具体装饰角色
 */
public class FlyCar extends SupperCar {

	public FlyCar(CarInterface car) {
		super(car);
	}

	public void fly(){
		System.out.println("在天上飞");
	}

	@Override
	public void move() {
		super.move();
		fly();
	}
}
