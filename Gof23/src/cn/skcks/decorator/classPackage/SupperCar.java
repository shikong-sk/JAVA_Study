package cn.skcks.decorator.classPackage;

import cn.skcks.decorator.interfacePackage.CarInterface;

/*
	Decorator 装饰角色
 */
public class SupperCar implements CarInterface {
	protected CarInterface car;

	public SupperCar(CarInterface car) {
		this.car = car;
	}

	@Override
	public void move() {
		car.move();
	}
}
