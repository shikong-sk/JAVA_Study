package cn.skcks.oop;

public class TestAnonymousInnerClass {
	
	public static void test(A a) {
		class Inner{
			public void innerFun() {
				System.out.println("Inner.InnerFun()");
			}
		}
		new Inner().innerFun();
		
		a.a();
	}
	
	public static void main(String[] args) {
		TestAnonymousInnerClass.test(new A() {

			/*
			 * 匿名内部类
			 */
			@Override
			public void a() {
				System.out.println("TestAnonymousInnerClass.main.new A(){a()}");			
			}
			
		});
	}
}

interface A{
	void a();
}

