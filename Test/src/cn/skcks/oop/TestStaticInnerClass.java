package cn.skcks.oop;

public class TestStaticInnerClass {
	public static void main(String[] args) {
		Outer2.Inner2 inner2 = new Outer2.Inner2();
		inner2.say();
	}
}

/*
 * 静态内部类不能直接访问外部类
 */
class Outer2{
	static class Inner2{
		public void say() {
			System.out.println("静态内部类 Test");
		}
	}
}