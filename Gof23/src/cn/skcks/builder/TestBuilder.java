package cn.skcks.builder;


import cn.skcks.builder.interfacePackage.AirShip;
import cn.skcks.builder.interfacePackage.AirShipDirector;
import cn.skcks.builder.interfacePackage.SkAirShipBuilder;
import cn.skcks.builder.interfacePackage.SkAirShipDirector;

/*
	建造者模式

	例：StringBuilder 的 append 方法
		SQL 中 的 PreparedStatement
		JDOM 中 DOMBuilder、SAXBuilder
 */
public class TestBuilder {
	public static void main(String[] args) {
		AirShipDirector airShipDirector = new SkAirShipDirector(new SkAirShipBuilder());

		AirShip airShip = airShipDirector.directAirShip();

		System.out.println(airShip.getEngine().getName());
		System.out.println(airShip.getOrbitalModule().getName());
		System.out.println(airShip.getEscapeTower().getName());
	}
}
