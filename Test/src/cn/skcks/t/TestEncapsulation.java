package cn.skcks.t;

import cn.skcks.Human;

public class TestEncapsulation {
	public static void main(String args[]) {
		Human human = new Human();
//		human.age = 20; ˽�����Բ��ɼ�
////		human.name = "ʱ��"; default ���Բ�ͬ�����ɼ�
//		human.height; protected ���� ͬ�� �� ��ͬ��������ɼ�
		Boy boy = new Boy();
		Girl girl = new Girl();
		
		System.out.println(human.getClass());
		System.out.println(boy.getHeight() + "��");
		
		girl.setHeight(163);
		System.out.println(girl.getHeight() + "����");
		
		boy.setAge(20);
		System.out.println(boy.getAge());
		
		boy.setAge(200);
		System.out.println(boy.getAge());
		
		boy.setName("ʱ��");
		System.out.println(boy.getName());
	}
	
	static double getHeight(Human h) {
		return h.getHeight();
	}

}

class Boy extends Human{
	public double getHeight() {
//		System.out.println(age); �����޷�ʹ�ø����˽�����Ժͷ���
		return height/100;
	}
	
}

class Girl extends Human{
	public double getHeight() {
//		System.out.println(age); �����޷�ʹ�ø����˽�����Ժͷ���
		return height*10;
	}
	
}