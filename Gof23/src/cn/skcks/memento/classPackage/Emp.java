package cn.skcks.memento.classPackage;

/*
	原发器类
 */
public class Emp {
	private String name;
	private int age;
	private double salary;

	// 进行备忘操作 并返回备忘录对象
	public EmpMemento memento(){
		return new EmpMemento(this);
	}

	// 将备忘录恢复为指定对象的值
	public void recovery(EmpMemento empMemento)
	{
		this.name = empMemento.getName();
		this.age = empMemento.getAge();
		this.salary = empMemento.getSalary();
	}

	public Emp(String name, int age, double salary) {
		this.name = name;
		this.age = age;
		this.salary = salary;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}
}
