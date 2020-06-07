package cn.skcks.factory.abstractFactory.interfacePackage;

public interface Tyre {
	void revolve();
}

class LuxuryTyre implements Tyre{
	@Override
	public void revolve() {
		System.out.println("耐磨轮胎");
	}
}

class LowTyre implements Tyre{
	@Override
	public void revolve() {
		System.out.println("普通轮胎");
	}
}