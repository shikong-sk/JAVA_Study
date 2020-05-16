package cn.skcks.oop;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TestGeneric {
	public static void main(String[] args) {
		MyCollection<String> myCollection = new MyCollection<String>();
		
		myCollection.set("时", 0);
		
		System.out.println(myCollection.get(0));
		
		List list = new ArrayList();
		
		Map map = new HashMap();
	}
}

class MyCollection<E>{
	Object object[] = new Object[5];
	
	public void set(E obj ,int index) {
		object[index] = obj;
	}
	
	public E get(int index) {
		return (E)object[index];
	}
}
