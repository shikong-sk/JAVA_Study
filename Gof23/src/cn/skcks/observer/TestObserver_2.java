package cn.skcks.observer;

import cn.skcks.observer.classPackage.ConcreteObserver;
import cn.skcks.observer.classPackage.ConcreteObserver_2;
import cn.skcks.observer.classPackage.ConcreteSubject;
import cn.skcks.observer.classPackage.ConcreteSubject_2;

/*
	观察者模式

	Java 自带方法
 */
public class TestObserver_2 {
	public static void main(String[] args) {
		// 目标对象
		ConcreteSubject_2 concreteSubject = new ConcreteSubject_2();

		// 创建多个观察者
		ConcreteObserver_2 concreteObserver1 = new ConcreteObserver_2();
		ConcreteObserver_2 concreteObserver2 = new ConcreteObserver_2();
		ConcreteObserver_2 concreteObserver3 = new ConcreteObserver_2();

		// 将观察者添加到 目标对象的 观察者列表中
		concreteSubject.addObserver(concreteObserver1);
		concreteSubject.addObserver(concreteObserver2);
		concreteSubject.addObserver(concreteObserver3);

		// 改变 Subject
		concreteSubject.setState(1024);

		System.out.println(concreteObserver1.getMyState());
		System.out.println(concreteObserver2.getMyState());
		System.out.println(concreteObserver3.getMyState());

		System.out.println();

		// 改变 Subject
		concreteSubject.setState(2048);
		System.out.println(concreteObserver1.getMyState());
		System.out.println(concreteObserver2.getMyState());
		System.out.println(concreteObserver3.getMyState());
	}
}
