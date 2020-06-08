package cn.skcks.flyWeight.interfacePackage;

import cn.skcks.flyWeight.classPackage.Coordinate;

/*
	享元类
	FlyWeight
 */
public interface Chess {
	void setColor(String color);
	String getColor();
	void display(Coordinate coordinate);
}
