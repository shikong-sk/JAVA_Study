package cn.skcks.decorator.classPackage;

import cn.skcks.decorator.interfacePackage.CarInterface;

/*
	ConcreteDecorator
	具体装饰角色
 */
public class WaterCar extends SupperCar {

	public WaterCar(CarInterface car) {
		super(car);
	}

	public void swim(){
		System.out.println("在水里游");
	}

	@Override
	public void move() {
		super.move();
		swim();
	}
}
