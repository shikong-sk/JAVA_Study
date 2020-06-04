package cn.skcks.classLoader.bean;

public class User {
	private String id;
	private String name;

	public String say(String who) {
		System.out.println(who + "：Hello World!");
		return "返回值 => " + who + "：Hello World!";
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
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