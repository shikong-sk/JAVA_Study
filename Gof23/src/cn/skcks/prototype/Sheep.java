package cn.skcks.prototype;

import java.io.Serializable;
import java.util.Date;

public class Sheep implements Cloneable, Serializable {
	private String name;
	private Date both;

	public Sheep(String name, Date both) {
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
		//直接调用 Object 的克隆方法
		return super.clone();
	}

}
