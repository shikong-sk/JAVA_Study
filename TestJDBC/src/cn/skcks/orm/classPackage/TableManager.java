package cn.skcks.orm.classPackage;

import cn.skcks.orm.bean.ColumnInfo;
import cn.skcks.orm.bean.TableInfo;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/*
	获取数据库表结构 并生成 类
 */
public class TableManager {

	private static Map<String, TableInfo> tables = new HashMap<>();

	public static Map<Class<?>, ColumnInfo> tableMap = new HashMap<>();

	static {
		try {
			Connection connection = DbManager.getConnection();
			assert connection != null;
			DatabaseMetaData databaseMetaData = connection.getMetaData();

			ResultSet tableRes = databaseMetaData.getTables(null,"%","%",new String[]{"TABLE"});

			while (tableRes.next())
			{
				// 获取所有表名
				String tableName = tableRes.getString("TABLE_NAME");

				tables.put(tableName,new TableInfo(tableName,new HashMap<String, ColumnInfo>(),null));

				// 获取所有字段
				ResultSet columnRes = databaseMetaData.getColumns(null,"%",tableName,"%");

				while (columnRes.next())
				{
					tables.get(tableName).getColumn().put(columnRes.getString("COLUMN_NAME"),
							new ColumnInfo(
									columnRes.getString("COLUMN_NAME"),
									columnRes.getString("TYPE_NAME"),
									0
							)
					);
				}

				ResultSet primaryKeyRes = databaseMetaData.getPrimaryKeys(null,"%",tableName);
				while (primaryKeyRes.next())
				{
					tables.get(tableName).getColumn().get(primaryKeyRes.getString("COLUMN_NAME")).setKeyType(1);
					tables.get(tableName).setPrimaryKey(tables.get(tableName).getColumn().get(primaryKeyRes.getString("COLUMN_NAME")));
				}

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		Map<String,TableInfo> tables = TableManager.tables;

		for(String tableName:tables.keySet())
		{
			System.out.format("%-10s%10s 表信息：\n","",tableName);
			for(String columnName:tables.get(tableName).getColumn().keySet()){
				System.out.format("%-30s\t%-10s\n",tables.get(tableName).getColumn().get(columnName).getField(),tables.get(tableName).getColumn().get(columnName).getType());
			}
			System.out.println();
		}
	}
}