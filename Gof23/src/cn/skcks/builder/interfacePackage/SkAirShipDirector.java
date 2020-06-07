package cn.skcks.builder.interfacePackage;

public class SkAirShipDirector implements AirShipDirector{

	private AirShipBuilder builder;

	public SkAirShipDirector(AirShipBuilder builder) {
		this.builder = builder;
	}

	@Override
	public AirShip directAirShip() {
		Engine engine = builder.builderEngine();
		EscapeTower escapeTower = builder.builderEscapeTower();
		OrbitalModule orbitalModule = builder.builderOrbitalModule();

		// 装配对象
		AirShip airShip = new AirShip();
		airShip.setEngine(engine);
		airShip.setEscapeTower(escapeTower);
		airShip.setOrbitalModule(orbitalModule);

		return airShip;
	}
}
