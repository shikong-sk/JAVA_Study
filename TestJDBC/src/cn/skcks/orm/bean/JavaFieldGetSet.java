package cn.skcks.orm.bean;

public class JavaFieldGetSet {

//	属性 源码 信息
	private String fieldInfo;

//	get 源码 信息
//	例：public Object getUserId(){}
	private String getFieldInfo;
//	set 源码 信息
//	例：public Object setUserId(Object id){this.id = id;}
	private String setFieldInfo;

	public String getFieldInfo() {
		return fieldInfo;
	}

	public void setFieldInfo(String fieldInfo) {
		this.fieldInfo = fieldInfo;
	}

	public String getGetFieldInfo() {
		return getFieldInfo;
	}

	public void setGetFieldInfo(String getFieldInfo) {
		this.getFieldInfo = getFieldInfo;
	}

	public String getSetFieldInfo() {
		return setFieldInfo;
	}

	public void setSetFieldInfo(String setFieldInfo) {
		this.setFieldInfo = setFieldInfo;
	}

	public JavaFieldGetSet(String fieldInfo, String getFieldInfo, String setFieldInfo) {
		this.fieldInfo = fieldInfo;
		this.getFieldInfo = getFieldInfo;
		this.setFieldInfo = setFieldInfo;
	}

	public JavaFieldGetSet() {
	}

	@Override
	public String toString() {
		return getFieldInfo() + getGetFieldInfo() + getSetFieldInfo();
	}
}