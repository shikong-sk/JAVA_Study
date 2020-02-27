package cn.skcks.oop;

/*
 * 抽象类
 * 
 * 不能实例化 ，只能用来继承
 * 没有实现的方法，子类必须实现
 * 构造方法不能new实例，只能被子类调用
 */
abstract public class Animal {

	abstract public void shout();

	public void run() {
		System.out.println("跑！");
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
		System.out.println("狗叫了一声！");
	}

}