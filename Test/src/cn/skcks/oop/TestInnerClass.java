package cn.skcks.oop;

public class TestInnerClass {
	public static void main(String[] args) {
//		/*
//		 * �ⲿ�����
//		 */
//		Outer outer = new Outer();
		
		/*
		 * �����ڲ������
		 */
		Outer.Inner inner = new Outer().new Inner();
		
		inner.show();
	}
}

class Outer{
	private int age = 10; // �ⲿ�����
	
	public void testOuter() {
		System.out.println("Outer.testOuter()");
	}
	
	/*
	 * �Ǿ�̬�ڲ���
	 * 
	 * ����ֱ�ӷ����ⲿ��
	 * �ⲿ�಻��ֱ�ӷ��ʷǾ�̬�ڲ���
	 * �Ǿ�̬�ڲ��಻���о�̬�����򷽷�
	 */
	class Inner{
		int age = 20; // �ڲ������
		public void show() {
			int age = 30; // �ֲ�����
			System.out.printf("�ֲ����� age = %d \n", age);
			System.out.printf("�ڲ������ age = %d \n", this.age);
			System.out.printf("�ⲿ��ĳ�Ա���� age = %d \n", Outer.this.age);
		}
	}
}
