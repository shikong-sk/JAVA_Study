package cn.skcks.oop;


import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/*
 * Collection 接口中的方法
 */
public class TestList {
	public static void main(String[] args) {
		
//		test1();
		
//		test2();
		
		test3();
	}
	
	public static void test1() {
		Collection<String> collection = new ArrayList<>();
		
		System.out.println(collection.size());
		System.out.println(collection.isEmpty());
		
		collection.add("第一个");
		collection.add("第二个");
		
		System.out.println(collection);
		System.out.println(collection.size());
		
		System.out.println(collection.contains("第一个"));
		System.out.println(collection.contains("第N个"));
		
		System.out.println(collection.toArray());
		for (Object string : collection.toArray()) {
			System.out.println(string);
		}
		
		collection.remove("第一个");
		System.out.println(collection);
		System.out.println(collection.size());
		
		
		collection.clear();
		System.out.println(collection.toString());
		System.out.println(collection.size());
	}
	
	public static void test2() {
		Collection<String> list1 = new ArrayList<>();
		
		list1.add("11");
		list1.add("22");
		list1.add("33");
		
		List<String> list2 = new ArrayList<>();
		
		list2.add("00");
		list2.add("11");
		list2.add("22");
		
		
		System.out.println("list1: " + list1);
		System.out.println("list2: " + list2);
		
//		list1.addAll(list2);	// 将list2直接添加到list1中
//		list1.removeAll(list2);	// 将list2与list1相同的内容删除
		list1.retainAll(list2);	// 取list2与list1的交集
		System.out.println("list1: " + list1);
		
		System.out.println(list1.containsAll(list2));	// list1是否包含list2所有元素
	}
	
	public static void test3() {
		List<String> list = new ArrayList<>();
		
		list.add("A");
		list.add("B");
		list.add("C");
		
		System.out.println(list);
		
		list.add(1,"A1");
		System.out.println(list);
		
		list.remove(2); 
		System.out.println(list);
		
		list.set(1,"B");
		System.out.println(list);

		list.add("B");
		System.out.println(list);
		System.out.println(list.get(1));
		System.out.println(list.indexOf("B"));
		System.out.println(list.lastIndexOf("B"));
		System.out.println(list.indexOf("X"));

	}
}
