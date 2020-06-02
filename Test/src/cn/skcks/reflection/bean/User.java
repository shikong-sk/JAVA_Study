package cn.skcks.reflection.bean;

import java.io.Serializable;

/*
	Java Bean 标准写法
 */
public class User implements Serializable {
	private int id;
	private String name;
	private int age;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public User(int id, String name, int age) {
		this.id = id;
		this.name = name;
		this.age = age;
	}

	// Java Bean 必须有无参构造器
	public User() {
	}
}
