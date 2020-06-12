package cn.skcks.orm.bean;

/*
	封装 表 字段 信息
 */
public class ColumnInfo {
	// 字段名
	private String field;

	// 数据类型
	private String type;

	// 键 类型
	private int keyType;

	public ColumnInfo() {
	}

	public ColumnInfo(String field, String type, int keyType) {
		this.field = field;
		this.type = type;
		this.keyType = keyType;
	}

	public String getField() {
		return field;
	}

	public void setField(String field) {
		this.field = field;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getKeyType() {
		return keyType;
	}

	public void setKeyType(int keyType) {
		this.keyType = keyType;
	}
}