package cn.skcks.oop;

public class TestInnerClass {
	public static void main(String[] args) {
//		/*
//		 * 外部类对象
//		 */
//		Outer outer = new Outer();
		
		/*
		 * 创建内部类对象
		 */
		Outer.Inner inner = new Outer().new Inner();
		
		inner.show();
	}
}

class Outer{
	private int age = 10; // 外部类变量
	
	public void testOuter() {
		System.out.println("Outer.testOuter()");
	}
	
	/*
	 * 非静态内部类
	 * 
	 * 可以直接访问外部类
	 * 外部类不能直接访问非静态内部类
	 * 非静态内部类不能有静态变量或方法
	 */
	class Inner{
		int age = 20; // 内部类变量
		public void show() {
			int age = 30; // 局部变量
			System.out.printf("局部变量 age = %d \n", age);
			System.out.printf("内部类变量 age = %d \n", this.age);
			System.out.printf("外部类的成员变量 age = %d \n", Outer.this.age);
		}
	}
}
