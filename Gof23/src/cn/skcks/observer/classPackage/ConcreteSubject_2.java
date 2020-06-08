package cn.skcks.observer.classPackage;

import java.util.Observable;

// 目标对象
public class ConcreteSubject_2 extends Observable {
	private int state;

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;

		// 表示目标对象已被更改
		setChanged();
		// 通知所有观察者
		notifyObservers(state);
	}
}
