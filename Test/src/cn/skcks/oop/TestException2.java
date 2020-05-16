package cn.skcks.oop;

public class TestException2 {
	public static void main(String[] args) {
		Person person = new Person();
		person.setAge(300);
	}
}

class Person{
	private int age;
	
	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		if(age < 0)
		{
			throw new IllegalAgeRunTimeExpection("年龄不能为负数");
		}

		try {
			if(age > 200)
			{
				throw new IllegalAgeExpection("年龄不能大于200");
			}
		} catch (IllegalAgeExpection e) {
			e.printStackTrace();
		}
			
		this.age = age;
	}
	
	
}

class IllegalAgeExpection extends Exception{
	
	public IllegalAgeExpection() {
		// TODO Auto-generated constructor stub
	}
	
	public IllegalAgeExpection(String msg) {
		// TODO Auto-generated constructor stub
		super(msg);
	}
	
}

class IllegalAgeRunTimeExpection extends RuntimeException{
	
	public IllegalAgeRunTimeExpection() {
		// TODO Auto-generated constructor stub
	}
	
	public IllegalAgeRunTimeExpection(String msg) {
		// TODO Auto-generated constructor stub
		super(msg);
	}
	
}