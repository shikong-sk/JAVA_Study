package cn.skcks.observer.classPackage;

public class ConcreteSubject extends Subject{
	private int state;

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;

		// 目标值 发生变化时 通知所有观察者
		this.notifyAllObserver();
	}
}
