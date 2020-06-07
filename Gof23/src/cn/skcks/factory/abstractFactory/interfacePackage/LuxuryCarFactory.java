package cn.skcks.factory.abstractFactory.interfacePackage;

import cn.skcks.factory.abstractFactory.interfacePackage.*;public class LuxuryCarFactory implements CarFactory {
	@Override
	public Engine createEngine() {
		return new LuxuryEngine();
	}

	@Override
	public Seat createSeat() {
		return new LuxurySeat();
	}

	@Override
	public Tyre createTyre() {
		return new LuxuryTyre();
	}
}
