package cn.skcks.oop;

public class ImplementsInterface implements TestInterface {
	public void getAge() {
		// TODO Auto-generated method stub
		System.out.println("MAX_AGE µÄÖµÎª£º" + MAX_AGE);
	}
	
	public static void main(String[] args) {
		new ImplementsInterface().getAge();
	}
}
