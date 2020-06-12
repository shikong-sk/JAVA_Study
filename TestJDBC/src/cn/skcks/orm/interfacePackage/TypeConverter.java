package cn.skcks.orm.interfacePackage;

/*
	Java 与 数据库 类型相互转化
 */
public interface TypeConverter {
	// 数据库 转 Java
	String databaseType2JavaType(String columnType);

	// Java 转 数据库
	String javaType2DatabaseType(String javaType);
}
