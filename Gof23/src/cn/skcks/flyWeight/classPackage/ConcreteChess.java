package cn.skcks.flyWeight.classPackage;

import cn.skcks.flyWeight.interfacePackage.Chess;

/*
	具体享元类
 */
public class ConcreteChess implements Chess {

	private String color;

	public ConcreteChess(String color) {
		this.color = color;
	}

	@Override
	public void setColor(String color) {
		this.color = color;
	}

	@Override
	public String getColor() {
		return null;
	}

	@Override
	public void display(Coordinate coordinate) {
		System.out.println(color + "棋：" + coordinate.getX() + "，" + coordinate.getY());
	}
}
