package cn.skcks.flyWeight;

import cn.skcks.flyWeight.classPackage.ChessFlyWeightFactory;
import cn.skcks.flyWeight.classPackage.Coordinate;
import cn.skcks.flyWeight.interfacePackage.Chess;

/*
	享元模式
 */
public class TestFlyWeight {
	public static void main(String[] args) {
		Chess black = ChessFlyWeightFactory.getChess("黑");
		Chess black2 = ChessFlyWeightFactory.getChess("黑");

		Chess white = ChessFlyWeightFactory.getChess("白");

		System.out.println(black);
		System.out.println(black2);

		System.out.println(white);

		// 添加外部状态
		black.display(new Coordinate(10,10));
		white.display(new Coordinate(10,11));
		black2.display(new Coordinate(10,9));
	}
}
