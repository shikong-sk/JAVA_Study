package cn.skcks;

public class TestEncapsulation {
	public static void main(String[] args) {
		Human human = new Human();
//		human.age = 20; 私有属性不可见
		human.name = "时空";
	}

}

class Boy extends Human{
	void getAge(int age) {
//		System.out.println(age); 子类无法使用父类的私有属性和方法
	}
}