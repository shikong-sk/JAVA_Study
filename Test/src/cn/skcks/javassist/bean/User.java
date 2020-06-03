package cn.skcks.javassist.bean;

import java.io.Serializable;

public class User implements Serializable {
	private String id;
	private String name;

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
