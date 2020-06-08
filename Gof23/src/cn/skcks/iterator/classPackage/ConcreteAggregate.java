package cn.skcks.iterator.classPackage;

import cn.skcks.iterator.interfacePackage.Iterator;

import java.util.ArrayList;
import java.util.List;

/*
	自定义聚合类
 */
public class ConcreteAggregate {
	private List<Object> list = new ArrayList<>();

	public ConcreteAggregate() {
	}

	public void addObject(Object obj){
		this.list.add(obj);
	}

	public void removeObject(Object obj){
		this.list.remove(obj);
	}

	public List<Object> getList() {
		return list;
	}

	public void setList(List<Object> list) {
		this.list = list;
	}

	// 获取迭代器
	public Iterator createIterator(){
		return new ConcreteIterator();
	}

	// 内部类迭代器
	private class ConcreteIterator implements Iterator {
		// 记录游标位置
		private int cursor;

		@Override
		public void first() {
			cursor = 0;
		}

		@Override
		public void next() {
			if(cursor < list.size())
			{
				cursor++;
			}
		}

		@Override
		public boolean hasNext() {
			return cursor < list.size();
		}

		@Override
		public boolean isFirst() {
			return cursor == 0;
		}

		@Override
		public boolean isLast() {
			return cursor == (list.size() - 1);
		}

		@Override
		public Object getCurrentObj() {
			return list.get(cursor);
		}
	}
}
