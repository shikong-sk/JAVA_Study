package cn.skcks.iterator;

import cn.skcks.iterator.classPackage.ConcreteAggregate;
import cn.skcks.iterator.interfacePackage.Iterator;

/*
	迭代器模式
 */
public class Test {
	public static void main(String[] args) {
		ConcreteAggregate concreteAggregate = new ConcreteAggregate();

		concreteAggregate.addObject("123");
		concreteAggregate.addObject("456");
		concreteAggregate.addObject("789");

		Iterator iterator = concreteAggregate.createIterator();
		while (iterator.hasNext())
		{
			System.out.println(iterator.getCurrentObj());
			iterator.next();
		}
	}
}
