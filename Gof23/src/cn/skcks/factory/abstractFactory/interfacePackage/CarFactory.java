package cn.skcks.factory.abstractFactory.interfacePackage;

public interface CarFactory {
	Engine createEngine();
	Seat createSeat();
	Tyre createTyre();
}