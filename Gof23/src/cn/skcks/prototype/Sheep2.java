package cn.skcks.prototype;

import java.util.Date;

public class Sheep2 implements Cloneable{
	private String name;
	private Date both;

	public Sheep2(String name, Date both) {
		this.name = name;
		this.both = both;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getBoth() {
		return both;
	}

	public void setBoth(Date both) {
		this.both = both;
	}

	@Override
	protected Object clone() throws CloneNotSupportedException {
		Object obj = super.clone();

		// 实现 深克隆
		Sheep2 tmp = (Sheep2) obj;

		// 将属性也进行克隆
		tmp.both = (Date) this.both.clone();

		return tmp;
	}

}
