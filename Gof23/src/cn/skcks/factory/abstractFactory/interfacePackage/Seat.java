package cn.skcks.factory.abstractFactory.interfacePackage;

public interface Seat {
	void message();
}

class LuxurySeat implements Seat{
	@Override
	public void message() {
		System.out.println("高级座椅");
	}
}

class LowSeat implements Seat{
	@Override
	public void message() {
		System.out.println("普通座椅");
	}
}