package cn.skcks.orm.bean;

/*
	数据库连接 配置信息
 */
public class Configuration {
	// 驱动
	private String driver;

	// JDBC URL
	private String url;

	// 用户名
	private String user;

	// 密码
	private String password;

	// 数据库
	private String database;

	// 要生成的包名
	private String generatePackage;

	public String getDriver() {
		return driver;
	}

	public Configuration() {
	}

	public Configuration(String driver, String url, String user, String password, String database, String generatePackage) {
		this.driver = driver;
		this.url = url;
		this.user = user;
		this.password = password;
		this.database = database;
		this.generatePackage = generatePackage;
	}

	public String getGeneratePackage() {
		return generatePackage;
	}

	public void setGeneratePackage(String generatePackage) {
		this.generatePackage = generatePackage;
	}

	public void setDriver(String driver) {
		this.driver = driver;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getDatabase() {
		return database;
	}

	public void setDatabase(String database) {
		this.database = database;
	}
}