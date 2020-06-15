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

	// 要生成的包路径
	private String generatePackagePath;

	// 项目所使用的查询类
	private String queryClass;

	// 连接池最小值
	private int pool_min;

	// 连接池最大值
	private int pool_max;

	public String getDriver() {
		return driver;
	}

	public Configuration() {
	}

	/**
	 *
	 * @param driver 驱动名称
	 * @param url 数据库url连接
	 * @param user 数据库用户名
	 * @param password 数据库密码
	 * @param database 数据库
	 * @param generatePackage 生成的包名
	 * @param generatePackagePath 生成包的路径
	 * @param queryClass 指定构造查询语句的Query类
	 * @param pool_min 连接池最小值
	 * @param pool_max 连接池最大值
	 */
	public Configuration(String driver, String url, String user, String password, String database, String generatePackage, String generatePackagePath, String queryClass, int pool_min, int pool_max) {
		this.driver = driver;
		this.url = url;
		this.user = user;
		this.password = password;
		this.database = database;
		this.generatePackage = generatePackage;
		this.generatePackagePath = generatePackagePath;
		this.queryClass = queryClass;
		this.pool_min = pool_min;
		this.pool_max = pool_max;
	}

	public String getGeneratePackagePath() {
		return generatePackagePath;
	}

	public void setGeneratePackagePath(String generatePackagePath) {
		this.generatePackagePath = generatePackagePath;
	}

	public int getPool_min() {
		return pool_min;
	}

	public void setPool_min(int pool_min) {
		this.pool_min = pool_min;
	}

	public int getPool_max() {
		return pool_max;
	}

	public void setPool_max(int pool_max) {
		this.pool_max = pool_max;
	}

	public String getQueryClass() {
		return queryClass;
	}

	public void setQueryClass(String queryClass) {
		this.queryClass = queryClass;
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