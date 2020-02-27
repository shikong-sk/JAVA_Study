package cn.skcks.t;

import cn.skcks.Human;

public class TestEncapsulation {
	public static void main(String args[]) {
		Human human = new Human();
//		human.age = 20; 私有属性不可见
////		human.name = "时空"; default 属性不同包不可见
//		human.height; protected 属性 同包 和 不同包的子类可见
		Boy boy = new Boy();
		Girl girl = new Girl();
		
		System.out.println(human.getClass());
		System.out.println(boy.getHeight() + "米");
		
		girl.setHeight(163);
		System.out.println(girl.getHeight() + "毫米");
		
		boy.setAge(20);
		System.out.println(boy.getAge());
		
		boy.setAge(200);
		System.out.println(boy.getAge());
		
		boy.setName("时空");
		System.out.println(boy.getName());
	}
	
	static double getHeight(Human h) {
		return h.getHeight();
	}

}

class Boy extends Human{
	public double getHeight() {
//		System.out.println(age); 子类无法使用父类的私有属性和方法
		return height/100;
	}
	
}

class Girl extends Human{
	public double getHeight() {
//		System.out.println(age); 子类无法使用父类的私有属性和方法
		return height*10;
	}
	
}