package cn.skcks.observer.classPackage;

import java.util.Observable;
import java.util.Observer;

public class ConcreteObserver_2 implements Observer {
	// 需要与目标值保持一致的变量
	private int myState;

	@Override
	public void update(Observable o, Object arg) {
		myState = ((ConcreteSubject_2) o).getState();
	}

	public int getMyState() {
		return myState;
	}
}
