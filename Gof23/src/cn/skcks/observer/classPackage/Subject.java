package cn.skcks.observer.classPackage;

import cn.skcks.observer.interfacePackage.Observer;

import java.util.ArrayList;
import java.util.List;

public class Subject {
	protected final List<Observer> list = new ArrayList<>();

	public void registerObserver(Observer observer){
		list.add(observer);
	}

	public void removeObserver(Observer observer)
	{
		list.remove(observer);
	}

	// 通知所有观察者 更新
	public void notifyAllObserver(){
		for (Observer observer:list)
		{
			observer.update(this);
		}
	}
}
