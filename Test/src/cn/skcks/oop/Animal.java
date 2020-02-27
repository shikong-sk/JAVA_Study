package cn.skcks.oop;

/*
 * ������
 * 
 * ����ʵ���� ��ֻ�������̳�
 * û��ʵ�ֵķ������������ʵ��
 * ���췽������newʵ����ֻ�ܱ��������
 */
abstract public class Animal {

	abstract public void shout();

	public void run() {
		System.out.println("�ܣ�");
	}

	public static void main(String[] args) {
		Animal dog = new Dog();
		dog.shout();
	}
}

class Dog extends Animal {

	@Override
	public void shout() {
		// TODO Auto-generated method stub
		System.out.println("������һ����");
	}

}