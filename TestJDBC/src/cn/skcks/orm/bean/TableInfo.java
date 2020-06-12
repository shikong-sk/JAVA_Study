package cn.skcks.orm.bean;

import cn.skcks.orm.classPackage.DbManager;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.util.Map;

/*
	封装 表 结构 信息
 */
public class TableInfo {
	// 表名
	private String table;

	// 字段信息
	private Map<String, ColumnInfo> column;


	// 主键
	private ColumnInfo primaryKey;


	public TableInfo() {
	}

	public TableInfo(String table, Map<String, ColumnInfo> column, ColumnInfo primaryKey) {
		this.table = table;
		this.column = column;
		this.primaryKey = primaryKey;
	}

	public String getTable() {
		return table;
	}

	public void setTable(String table) {
		this.table = table;
	}

	public Map<String, ColumnInfo> getColumn() {
		return column;
	}

	public void setColumn(Map<String, ColumnInfo> column) {
		this.column = column;
	}

	public ColumnInfo getPrimaryKey() {
		return primaryKey;
	}

	public void setPrimaryKey(ColumnInfo primaryKey) {
		this.primaryKey = primaryKey;
	}


}