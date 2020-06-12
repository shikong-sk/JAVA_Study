package cn.skcks.jdbc;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.Statement;

/*
	与数据库建立连接
 */
public class Test {
	public static final String PREFIX = "jdbc:mysql://";

	public static void main(String[] args) {
		try {
			// 加载驱动类
			Class.forName("com.mysql.jdbc.Driver");

			String host = "127.0.0.1";

			int port = 3306;

			String database = "management_system";

			String user = "root";

			String password = "12341234";

			// 建立 数据库 连接
			// 实际开发中 为了提高效率 通常使用 连接池 来管理连接对象
			Connection connection = DriverManager.getConnection(PREFIX + host + ":" + port + "/" + database, user, password);

			System.out.println(connection);


		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}