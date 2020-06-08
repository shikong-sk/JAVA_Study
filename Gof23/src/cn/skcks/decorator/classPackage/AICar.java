package cn.skcks.decorator.classPackage;

import cn.skcks.decorator.interfacePackage.CarInterface;

/*
	ConcreteDecorator
	具体装饰角色
 */
public class AICar extends SupperCar {

	public AICar(CarInterface car) {
		super(car);
	}

	public void ai(){
		System.out.println("自动驾驶");
	}

	@Override
	public void move() {
		super.move();
		ai();
	}
}
