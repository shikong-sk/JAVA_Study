package cn.skcks.observer;

import cn.skcks.observer.classPackage.ConcreteObserver;
import cn.skcks.observer.classPackage.ConcreteSubject;

/*
	观察者模式
 */
public class TestObserver {
	public static void main(String[] args) {
		// 目标对象
		ConcreteSubject concreteSubject = new ConcreteSubject();

		// 创建多个观察者
		ConcreteObserver observer1 = new ConcreteObserver();
		ConcreteObserver observer2 = new ConcreteObserver();
		ConcreteObserver observer3 = new ConcreteObserver();

		// 将观察者添加到 目标对象的 观察者列表中
		concreteSubject.registerObserver(observer1);
		concreteSubject.registerObserver(observer2);
		concreteSubject.registerObserver(observer3);

		// 改变 Subject
		concreteSubject.setState(666);

		System.out.println(observer1.getMyState());
		System.out.println(observer2.getMyState());
		System.out.println(observer3.getMyState());

		System.out.println();

		// 改变 Subject
		concreteSubject.setState(1024);
		System.out.println(observer1.getMyState());
		System.out.println(observer2.getMyState());
		System.out.println(observer3.getMyState());

	}
}
