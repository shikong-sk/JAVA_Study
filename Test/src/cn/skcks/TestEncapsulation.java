package cn.skcks;

public class TestEncapsulation {
	public static void main(String[] args) {
		Human human = new Human();
//		human.age = 20; ˽�����Բ��ɼ�
		human.name = "ʱ��";
	}

}

class Boy extends Human{
	void getAge(int age) {
//		System.out.println(age); �����޷�ʹ�ø����˽�����Ժͷ���
	}
}