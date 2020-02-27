package cn.skcks.oop;

public class TestAnonymousInnerClass {
	
	public static void test(A a) {
		/*
		 * 方法内部类 （局部内部类）
		 * 作用域只限于本方法内，只能在方法内使用
		 */
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
			 * 没有构造方法
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

