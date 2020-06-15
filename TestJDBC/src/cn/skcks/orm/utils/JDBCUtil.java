package cn.skcks.orm.utils;

import java.io.Closeable;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;

/**
 * 	封装 JDBC Util 工具类
 * 	常用操作
 */
public class JDBCUtil {

	/**
	 * 读取资源文件信息
	 */
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

	/**
	 * 获取数据库连接
	 * @return Connection 数据库连接对象
	 */
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

	/**
	 * 关闭连接
	 * @param closeables 要关闭的对象
	 */
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

	/**
	 * 关闭连接
	 * @param closeables 要关闭的对象
	 */
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

	/**
	 * 处理构造参数
	 * @param preparedStatement sql预处理对象
	 * @param params 需要构造的参数
	 */
	public static void handleParams(PreparedStatement preparedStatement,Object[] params){
		if(params != null)
		{
			for (int i = 0; i < params.length; i++) {
				try {
					preparedStatement.setObject(i+1,params[i]);
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}
}