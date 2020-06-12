package cn.skcks.orm.utils;

import java.io.Closeable;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

/*
	封装 JDBC Util 工具类
	常用操作
 */
public class JDBCUtil {

	// 读取资源文件信息
	static Properties properties = null;

	// 加载时调用
	static {
		properties = new Properties();
		try {
			properties.load(Thread.currentThread().getContextClassLoader().getResourceAsStream("db.properties"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static final String PREFIX = "jdbc:mysql://";

	public static Connection getConnection() {
		try {
			// 加载驱动类
			Class.forName(properties.getProperty("Driver"));

			String host = properties.getProperty("Host");

			int port = Integer.parseInt(properties.getProperty("Port"));

			String database = properties.getProperty("Database");

			String user = properties.getProperty("User");

			String password = properties.getProperty("Password");

			// 建立 数据库 连接
			return DriverManager.getConnection(PREFIX + host + ":" + port + "/" + database, user, password);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public static void close(AutoCloseable... closeables) {
		for (AutoCloseable closeable : closeables) {
			try {
				if (closeable != null) {
					closeable.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public static void close(Closeable... closeables) {
		for (Closeable closeable : closeables) {
			try {
				if (closeable != null) {
					closeable.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}