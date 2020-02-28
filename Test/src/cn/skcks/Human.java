package cn.skcks;

public class Human{
	private int age;
	String name;
	protected double height = 168;
	
	public int getAge() {
//		System.out.println(this.age);
		return this.age;
	}
	
	public void setAge(int age) {
		if(age >= 0 && age <=120)
		{
			this.age = age;
		}
		else {
			this.age = 0;
			System.out.println("年龄格式不合法");
		}
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		if(name.length() < 2 || name.length() > 5)
		{
			System.out.println("姓名长度不合法");
		}
		else {			
			this.name = name;
		}
	}

	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		this.height = height;
	}
}