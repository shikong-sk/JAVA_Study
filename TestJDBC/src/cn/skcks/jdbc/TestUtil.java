package cn.skcks.jdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/*
	测试 JDBC Util 工具类
 */
public class TestUtil {
	public static void main(String[] args) {
		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;
		try {
			connection = JDBCUtil.getConnection();
			//创建 Statement 声明

			assert connection != null;
			statement = connection.createStatement();

			String sql = "SHOW TABLES";
			// 执行语句
			statement.execute(sql);

			// 获取执行结果
			resultSet = statement.getResultSet();
			while (resultSet.next())
			{
				System.out.println(resultSet.getString(1));
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(connection,statement,resultSet);
		}
	}
}