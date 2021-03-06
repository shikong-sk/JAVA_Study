package cn.skcks.orm.classPackage;

import cn.skcks.orm.interfacePackage.TypeConverter;

/**
 * Mysql 类型转换器
 */
public class MysqlTypeConverter implements TypeConverter {

	/**
	 * 数据库 数据类型 转化为 Java 数据类型
	 */
	@Override
	public String databaseType2JavaType(String columnType) {
		if ("VARCHAR".equalsIgnoreCase(columnType) || "CHAR".equalsIgnoreCase(columnType)) {
			return "String";
		} else if (
				"INT".equalsIgnoreCase(columnType)
						|| "TINYINT".equalsIgnoreCase(columnType)
						|| "BIT".equalsIgnoreCase(columnType)
						|| "INTEGER".equalsIgnoreCase(columnType)
		) {
			return "Integer";
		}
		else if("BIGINT".equalsIgnoreCase(columnType))
		{
			return "Long";
		}
		else if("DOUBLE".equalsIgnoreCase(columnType)||"FLOAT".equalsIgnoreCase(columnType))
		{
			return "Double";
		}
		else if("CLOB".equalsIgnoreCase(columnType))
		{
			return "java.sql.Clob";
		}
		else if("BLOB".equalsIgnoreCase(columnType))
		{
			return "java.sql.Blob";
		}
		else if("DATE".equalsIgnoreCase(columnType))
		{
			return "java.sql.Date";
		}
		else if("TIME".equalsIgnoreCase(columnType))
		{
			return "java.sql.Time";
		}
		else if("TIMESTAMP".equalsIgnoreCase(columnType))
		{
			return "java.sql.Timestamp";
		}
		return null;
	}

	/**
	 * Java 数据类型 转化为 数据库 数据类型
	 */
	@Override
	public String javaType2DatabaseType(String javaType) {
		return null;
	}
}