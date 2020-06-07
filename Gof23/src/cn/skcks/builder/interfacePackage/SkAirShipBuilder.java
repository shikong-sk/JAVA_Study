package cn.skcks.builder.interfacePackage;

public class SkAirShipBuilder implements AirShipBuilder {
	// 类似的 StringBuilder DomBuilder SaxBuilder 等
	@Override
	public Engine builderEngine() {
		System.out.println("构建 Engine");
		return new Engine("Sk Engine");
	}

	@Override
	public OrbitalModule builderOrbitalModule() {
		System.out.println("构建 OrbitalModule");
		return new OrbitalModule("Sk OrbitalModule");
	}

	@Override
	public EscapeTower builderEscapeTower() {
		System.out.println("构建 EscapeTower");
		return new EscapeTower("Sk EscapeTower");
	}
}
