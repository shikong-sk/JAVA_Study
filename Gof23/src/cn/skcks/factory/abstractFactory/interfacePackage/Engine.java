package cn.skcks.factory.abstractFactory.interfacePackage;

public interface Engine {
	void run();
	void start();
}

class  LuxuryEngine implements Engine{
	@Override
	public void run() {
		System.out.println("LuxuryEngine 运行");
	}

	@Override
	public void start() {
		System.out.println("LuxuryEngine 启动");
	}
}

class LowEngine implements Engine{
	@Override
	public void run() {
		System.out.println("LowEngine 运行");
	}

	@Override
	public void start() {
		System.out.println("LowEngine 启动");
	}
}