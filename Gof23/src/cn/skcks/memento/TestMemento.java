package cn.skcks.memento;

import cn.skcks.memento.classPackage.CareTaker;
import cn.skcks.memento.classPackage.Emp;

public class TestMemento {
	public static void main(String[] args) {
		CareTaker careTaker = new CareTaker();

		Emp emp = new Emp("时空",20,3000);

		System.out.println(emp.getName() + "\t" + emp.getAge() + "\t" + emp.getSalary());

		// 备忘一次
		careTaker.setEmpMemento(emp.memento());

		emp.setName("时光");
		emp.setAge(18);
		emp.setSalary(2800);

		System.out.println(emp.getName() + "\t" + emp.getAge() + "\t" + emp.getSalary());

		// 数据恢复
		emp.recovery(careTaker.getEmpMemento());

		System.out.println(emp.getName() + "\t" + emp.getAge() + "\t" + emp.getSalary());

	}
}
