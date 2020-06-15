package cn.skcks.orm.utils;

import cn.skcks.orm.bean.ColumnInfo;
import cn.skcks.orm.bean.JavaFieldGetSet;
import cn.skcks.orm.bean.TableInfo;
import cn.skcks.orm.classPackage.DbManager;
import cn.skcks.orm.classPackage.MysqlTypeConverter;
import cn.skcks.orm.classPackage.TableManager;
import cn.skcks.orm.interfacePackage.TypeConverter;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 封装 Java 文件生成 操作
 */
public class JavaFileUtils {
	/**
	 * 根据字段生成 java 属性信息 varchar id =&gt; private String id; 以及相应的 set、get方法
	 * @param columnInfo ColumnInfo 列信息
	 * @param typeConverter 类型转换器
	 * @return JavaFieldGetSet java字段 get、set 生成类
	 */
	public static JavaFieldGetSet createFieldGetSetSRC(ColumnInfo columnInfo, TypeConverter typeConverter) {
		JavaFieldGetSet javaFieldGetSet = new JavaFieldGetSet();

		String javaFieldType = typeConverter.databaseType2JavaType(columnInfo.getType());

		// Java 保留关键字 过滤
		String[] javaKeywords = new String[]{"class", "public"};

		for (String keyword : javaKeywords) {
			if (columnInfo.getField().equals(keyword)) {
				columnInfo.setField("_"+StringUtils.firstChar2UpperCase(columnInfo.getField()));
			}
		}

		javaFieldGetSet.setFieldInfo("\tprivate " + javaFieldType + " " + columnInfo.getField() + ";\r\n");

		StringBuilder src = new StringBuilder();

		src.append("\tpublic ").append(javaFieldType).append(" get")
				.append(StringUtils.firstChar2UpperCase(columnInfo.getField()))
				.append("(){\n");
		src.append("\t\treturn ").append(columnInfo.getField()).append(";\n");
		src.append("\t}\n");

		javaFieldGetSet.setGetFieldInfo(src.toString());

		src = new StringBuilder();

		src.append("\tpublic void set").append(StringUtils.firstChar2UpperCase(columnInfo.getField())).append("(").append(javaFieldType).append(" ").append(columnInfo.getField()).append("){\n");
		src.append("\t\tthis.").append(columnInfo.getField()).append(" = ").append(columnInfo.getField()).append(";\n");
		src.append("\t}\n");

		javaFieldGetSet.setSetFieldInfo(src.toString());

		return javaFieldGetSet;
	}

	/**
	 * 生成 Java 代码
	 * @param tableInfo TableInfo 数据库表信息
	 * @param converter 类型转换器
	 * @return 要生成的 Java 代码
	 */
	public static String createJavaSRC(TableInfo tableInfo, TypeConverter converter) {
		StringBuilder src = new StringBuilder();

		Map<String, ColumnInfo> columns = tableInfo.getColumn();

		List<JavaFieldGetSet> javaFields = new ArrayList<>();

		for (ColumnInfo column : columns.values()) {
			javaFields.add(createFieldGetSetSRC(column, converter));
		}

		// 生成 package 语句
		src.append("package ").append(DbManager.getConfig().getGeneratePackage()).append(";\n\n");

		// 生成 import 语句
		src.append("import java.sql.*;\n");
		src.append("import java.util.*;\n\n");

		// 生成 类声明 语句
		src.append("public class ").append(StringUtils.firstChar2UpperCase(tableInfo.getTable())).append(" {\n\n");

		// 生成属性列表
		for (JavaFieldGetSet javaFieldGetSet : javaFields) {
			src.append(javaFieldGetSet.getFieldInfo());
		}
		src.append("\n");

		// 生成 get 方法
		for (JavaFieldGetSet javaFieldGetSet : javaFields) {
			src.append(javaFieldGetSet.getGetFieldInfo());
		}

		// 生成 set 方法
		for (JavaFieldGetSet javaFieldGetSet : javaFields) {
			src.append(javaFieldGetSet.getSetFieldInfo());
		}

		src.append("}\n");

		return src.toString();
	}

	@SuppressWarnings("all")
	/**
	 * 创建 Java 文件
	 */
	public static void createJavaFile(TableInfo tableInfo, TypeConverter converter) {
		String src = createJavaSRC(tableInfo, converter);

		String dir = new File(DbManager.getConfig().getGeneratePackagePath()).getAbsolutePath() + File.separator
					+ "generatePackage" + File.separator + DbManager.getConfig().getGeneratePackage().replace(".", File.separator);

		String path =
				dir + File.separator + StringUtils.firstChar2UpperCase(tableInfo.getTable()) + ".java";

		File dirFile = new File(dir);
		File pathFile = new File(path);

		System.out.println(path);

		if (!dirFile.exists()) {
			dirFile.mkdirs();
		}

//		System.out.println(new File(path).getAbsolutePath());

//		System.exit(0);

		BufferedWriter bufferedWriter = null;
		try {
			bufferedWriter = new BufferedWriter(new FileWriter(pathFile));

			bufferedWriter.write(src);
			bufferedWriter.flush();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DbManager.close(bufferedWriter);
		}

	}

	/**
	 * 根据 表结构 更新 Java 类文件
	 */
	public static void updateJavaFile() {
		Map<String, TableInfo> tables = TableManager.tables;
		for (TableInfo tableInfo : tables.values()) {
			createJavaFile(tableInfo, new MysqlTypeConverter());
		}
	}

	public static void main(String[] args) {
//		ColumnInfo columnInfo = new ColumnInfo("username","varchar",0);
//		JavaFieldGetSet javaFieldGetSet = createFieldGetSetSRC(columnInfo,new MysqlTypeConverter());
//
//		System.out.println(javaFieldGetSet);


//		Map<String, TableInfo> tables = TableManager.tables;
//		TableInfo tableInfo = tables.get("ms_student");
//		System.out.println(createJavaSRC(tableInfo, new MysqlTypeConverter()));
//
//		System.out.println(System.getProperty("user.dir"));

		Map<String, TableInfo> tables = TableManager.tables;
//		TableInfo tableInfo = tables.get("ms_student");
//		createJavaFile(tableInfo, new MysqlTypeConverter());
		for (TableInfo tableInfo : tables.values()) {
			createJavaFile(tableInfo, new MysqlTypeConverter());
		}
	}
}