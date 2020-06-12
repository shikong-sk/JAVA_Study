package cn.skcks.jdbc;

import java.sql.*;

/*
	与数据库建立连接

	Statement 执行 SQL 语句

	使用 PreparedStatement 执行 SQL 语句      防 SQL 注入
 */
public class Test_3 {
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

			String sql;

			// 占位符 ?
			sql = "SELECT `studentId`,`studentName`,`departmentName`,`majorName` FROM ms_student WHERE `departmentId` = ? AND `majorId` = ?";

			//创建 PreparedStatement 预处理声明
			PreparedStatement statement = connection.prepareStatement(sql);

			statement.setString(1, "05");
			statement.setObject(2, "02");

			// 执行语句
			statement.execute();

			// 获取执行结果
			ResultSet res = statement.getResultSet();
			while (res.next()) {
				System.out.println(res.getString(1) + "\t"
						+ res.getString(2) + "\t"
						+ res.getString(3) + "\t"
						+ res.getString(4));
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}