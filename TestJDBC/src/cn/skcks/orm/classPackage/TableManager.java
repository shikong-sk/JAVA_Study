package cn.skcks.orm.classPackage;

import cn.skcks.orm.bean.ColumnInfo;
import cn.skcks.orm.bean.TableInfo;
import cn.skcks.orm.utils.JavaFileUtils;
import cn.skcks.orm.utils.StringUtils;

import javax.tools.ToolProvider;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.net.URL;
import java.net.URLClassLoader;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


/**
 * 获取数据库表结构 并生成 类
 */
public class TableManager {

	public static Map<String, TableInfo> tables = new HashMap<>();

	public static Map<Class<?>, TableInfo> tableMap = new HashMap<>();

	/**
	 * 类加载器
	 */
	private static ClassLoader classLoader;

	static {
		try {
			Connection connection = DbManager.getConnection();

			if(connection == null)
			{
				throw new RuntimeException("数据库连接失败");
			}

			DatabaseMetaData databaseMetaData = connection.getMetaData();

			classLoader = new URLClassLoader(new URL[]{new File(System.getProperty("user.dir") + File.separator + "generatePackage").toURI().toURL()});

			ResultSet tableRes = databaseMetaData.getTables(null, "%", "%", new String[]{"TABLE"});

			while (tableRes.next()) {
				// 获取所有表名
				String tableName = tableRes.getString("TABLE_NAME");

				tables.put(tableName, new TableInfo(tableName, new HashMap<String, ColumnInfo>(), null));

				// 获取所有字段
				ResultSet columnRes = databaseMetaData.getColumns(null, "%", tableName, "%");

				while (columnRes.next()) {
					tables.get(tableName).getColumn().put(columnRes.getString("COLUMN_NAME"),
							new ColumnInfo(
									columnRes.getString("COLUMN_NAME"),
									columnRes.getString("TYPE_NAME"),
									0
							)
					);
				}

				ResultSet primaryKeyRes = databaseMetaData.getPrimaryKeys(null, "%", tableName);
				while (primaryKeyRes.next()) {
//					System.out.println(tableName + "\t" +primaryKeyRes.getString("COLUMN_NAME"));
					tables.get(tableName).getColumn().get(primaryKeyRes.getString("COLUMN_NAME")).setKeyType(1);
					tables.get(tableName).setPrimaryKey(tables.get(tableName).getColumn().get(primaryKeyRes.getString("COLUMN_NAME")));
				}

			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		JavaFileUtils.updateJavaFile();

		loadTablePackage();
	}

	/**
	 * 动态生成并加载Table类
	 */
	public static void loadTablePackage() {
		try {
			for (TableInfo tableInfo : tables.values()) {

				String path = new File(DbManager.getConfig().getGeneratePackagePath()).getAbsolutePath() + File.separator
						+ "generatePackage" + File.separator
						+ DbManager.getConfig().getGeneratePackage().replace(".", File.separator)
						+ File.separator + StringUtils.firstChar2UpperCase(tableInfo.getTable());

				// 动态编译
				ToolProvider.getSystemJavaCompiler().run(null, null, null, path + ".java");

//				// 指定类加载器
//				ClassLoader classLoader = new URLClassLoader(new URL[]{new File(System.getProperty("user.dir") + File.separator + "generatePackage").toURI().toURL()});
//
//				// 动态加载类
//				Class<?> c = classLoader.loadClass(DbManager.getConfig().getGeneratePackage() + "." + StringUtils.firstChar2UpperCase(tableInfo.getTable()));

				Class<?> c = classLoader(tableInfo.getTable());

				tableMap.put(c, tableInfo);
			}

//			for (Class<?> clz : tableMap.keySet()) {
//				System.out.println(clz.getName());
//			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 *
	 * @param cls 要加载的类名
	 * @return 类
	 */
	public static Class<?> classLoader(String cls) {
		try {
//			// 指定类加载器
//			classLoader = new URLClassLoader(new URL[]{new File(System.getProperty("user.dir") + File.separator + "generatePackage").toURI().toURL()});

			// 动态加载类
			return classLoader.loadClass(DbManager.getConfig().getGeneratePackage() + "." + StringUtils.firstChar2UpperCase(cls));

		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public static void main(String[] args) {
		Map<String, TableInfo> tables = TableManager.tables;

		for (String tableName : tables.keySet()) {
			System.out.format("%-10s%10s 表信息：\n", "", tableName);
			for (String columnName : tables.get(tableName).getColumn().keySet()) {
				System.out.format("%-30s\t%-10s\n", tables.get(tableName).getColumn().get(columnName).getField(), tables.get(tableName).getColumn().get(columnName).getType());
			}
			System.out.println();
		}
	}
}