package cn.skcks.orm.classPackage;

import cn.skcks.orm.bean.Configuration;

import java.io.Closeable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

/*
	连接对象、连接池管理
 */
public class DbManager {
	private static Configuration config;

	static {
		Properties properties = new Properties();
		try {
			properties.load(Thread.currentThread().getContextClassLoader().getResourceAsStream("db.properties"));

			config = new Configuration();
			config.setDriver(properties.getProperty("Driver"));
			config.setUrl(properties.getProperty("Url_Prefix") + properties.getProperty("Host") + ":" + properties.getProperty("Port"));
			config.setUser(properties.getProperty("User"));
			config.setPassword(properties.getProperty("Password"));
			config.setDatabase(properties.getProperty("Database"));

			config.setGeneratePackage(properties.getProperty("GeneratePackage"));

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static Configuration getConfig() {
		return config;
	}

	public static Connection getConnection() {
		try {

			Class.forName(config.getDriver());
			return DriverManager.getConnection(config.getUrl() + "/" + config.getDatabase(),config.getUser(),config.getPassword());

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