package cn.skcks.orm.pool;

import cn.skcks.orm.classPackage.DbManager;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * 连接池
 */
public class DbConnectionPool {
	/**
	 * 连接池对象
	 */
	private List<Connection> pool;

	/**
	 * 最大连接数
	 */
	private static final int POOL_MAX = DbManager.getConfig().getPool_max();

	/**
	 * 最小连接数
	 */
	private static final int POOL_MIN = DbManager.getConfig().getPool_min();


	/**
	 * 初始化连接池
	 */
	public void initPool(){
		if(pool == null)
		{
			pool = new ArrayList<>();
		}

		while (pool.size() < POOL_MIN)
		{
			pool.add(DbManager.createConnection());
		}
	}

	/**
	 *
	 * @return 从连接池获取可用连接
	 */
	public synchronized Connection getConnection() {
		int last = pool.size() - 1;
		Connection connection = pool.get(last);
		pool.remove(connection);
		return connection;
	}

	/**
	 *
	 * @param connection 要关闭的数据库连接
	 */
	public synchronized void close(Connection connection) {
		if(pool.size() >= POOL_MAX)
		{
			if(connection != null)
			{
				try {
					connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		else{
			pool.add(connection);
		}
	}

	public DbConnectionPool() {
		initPool();
	}
}