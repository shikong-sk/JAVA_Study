package cn.skcks.observer.classPackage;

import cn.skcks.observer.interfacePackage.Observer;

public class ConcreteObserver implements Observer {
	// 需要与目标值保持一致的变量
	private int myState;

	@Override
	public void update(Subject subject) {
		myState = ((ConcreteSubject) subject).getState();
	}

	public int getMyState() {
		return myState;
	}

	public void setMyState(int myState) {
		this.myState = myState;
	}
}
