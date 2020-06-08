package cn.skcks.decorator;

import cn.skcks.decorator.classPackage.*;

/*
	装饰器模式
 */
public class TestDecorator {
	public static void main(String[] args) {
		Car car = new Car();
		car.move();
		System.out.println();

		System.out.println("添加 飞行 装饰器");

		FlyCar flyCar = new FlyCar(car);
		flyCar.move();
		System.out.println();

		System.out.println("添加 游泳 装饰器");

		WaterCar waterCar = new WaterCar(car);
		waterCar.move();
		System.out.println();

		System.out.println("添加 飞行、游泳 装饰器");
		WaterCar waterCar2 = new WaterCar(new FlyCar(car));
		waterCar2.move();
		System.out.println();

		System.out.println("添加 飞行、游泳、AI 装饰器");
		AICar aiCar = new AICar(new WaterCar(new FlyCar(car)));
		aiCar.move();
		System.out.println();
	}
}
