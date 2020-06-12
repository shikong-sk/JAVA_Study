package cn.skcks.jdbc;

import java.sql.*;

/*
	与数据库建立连接

	Statement 执行 SQL 语句

	使用 PreparedStatement 执行 SQL 语句      防 SQL 注入

	ResultSet 结果集

	批量处理
 */
public class Test_5 {
	public static final String PREFIX = "jdbc:mysql://";

	public static void main(String[] args) {
		Connection connection = null;
		Statement statement = null;
		ResultSet res = null;
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
			connection = DriverManager.getConnection(PREFIX + host + ":" + port + "/" + database, user, password);

			// 关闭自动提交
			connection.setAutoCommit(false);


			//创建 Statement 声明
			statement = connection.createStatement();

			for (int i = 0; i < 100; i++) {
				statement.addBatch("INSERT INTO `management_system`.`ms_student`(`studentId`, `studentName`, `gender`, `both`, `salt`, `password`, `contact`, `grade`, `years`, `departmentId`, `departmentName`, `majorId`, `majorName`, `class`, `classId`, `seat`, `active`, `idCard`, `address`, `studentImg`) VALUES ('17305023" + i + "', 'XXX', '', '1999-01-21', '', '', '', '17', '3', '05', '计算机系', '02', '计算机应用技术', '1', '17305023', '01', 0, '440000199910011" + i +"', '{}', '');\n");
			}

			// 批量执行语句
			statement.executeBatch();

			String sql = "SELECT * FROM ms_student";

			// 执行查询语句
			statement.execute(sql);

			// 获取执行结果
			res = statement.getResultSet();

			while (res.next())
			{
				System.out.println(res.getString(1));
			}

			// 提交事务
//			connection.commit();

			// 回滚事务
			connection.rollback();

			System.out.println();

			// 执行查询语句
			statement.execute(sql);

			// 获取执行结果
			res = statement.getResultSet();

			while (res.next())
			{
				System.out.println(res.getString(1));
			}

		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			// 关闭顺序 ResultSet => Statement => Connection
			if(res != null)
			{
				try {

					// 关闭 结果集对象
					res.close();

				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(statement != null)
			{
				try {

					// 关闭 声明对象
					statement.close();

				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(connection != null)
			{
				try {
					// 关闭 数据库 连接
					connection.close();

				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}
}