package cn.skcks.flyWeight.classPackage;

import cn.skcks.flyWeight.interfacePackage.Chess;

import java.util.HashMap;
import java.util.Map;

/*
	享元工厂类
 */
public class ChessFlyWeightFactory {
	// 享元池
	private static final Map<String, Chess> map = new HashMap<>();

	public static Chess getChess(String color){
		if(map.get(color) != null)
		{
			return map.get(color);
		}
		else{
			Chess chess = new ConcreteChess(color);
			map.put(color,chess);
			return chess;
		}
	}

}
