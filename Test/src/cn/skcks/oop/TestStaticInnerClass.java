package cn.skcks.oop;

public class TestStaticInnerClass {
	public static void main(String[] args) {
		Outer2.Inner2 inner2 = new Outer2.Inner2();
		inner2.say();
	}
}

/*
 * ��̬�ڲ��಻��ֱ�ӷ����ⲿ��
 */
class Outer2{
	static class Inner2{
		public void say() {
			System.out.println("��̬�ڲ��� Test");
		}
	}
}