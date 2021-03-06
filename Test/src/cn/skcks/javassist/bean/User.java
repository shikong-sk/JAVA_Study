package cn.skcks.javassist.bean;

import cn.skcks.javassist.annotation.Author;

import java.io.Serializable;

@Author(name = "时空",year = 2020)
public class User implements Serializable {
	private String id;
	private String name;

	public String say(String who){
		System.out.println(who + "：Hello World!");
		return "返回值 => " + who + "：Hello World!";
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public User() {
	}

	public User(String id, String name) {
		this.id = id;
		this.name = name;
	}
}
