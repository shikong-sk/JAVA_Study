package cn.skcks.orm;

import cn.skcks.jdbc.JDBCUtil;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
	使用 Object[] 封装记录
 */
public class Test {
	public static void main(String[] args) {
		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;
		List<Map<String,Object>> list = new ArrayList<>();
		Map<String,Object> data;
		try {
			connection = JDBCUtil.getConnection();
			//创建 Statement 声明

			assert connection != null;
			statement = connection.createStatement();

			String sql = "SELECT studentId,studentName FROM ms_student";
			// 执行语句
			statement.execute(sql);

			// 获取执行结果
			resultSet = statement.getResultSet();
			while (resultSet.next())
			{
				data = new HashMap<>();
				data.put(resultSet.getMetaData().getColumnName(1),resultSet.getString(1));
				data.put(resultSet.getMetaData().getColumnName(2),resultSet.getString(2));
				list.add(data);
			}

			for (Map<String,Object> d:list)
			{
				for(String key:d.keySet())
				{
					System.out.print(key + " => " + d.get(key) + "\t");
				}
				System.out.println();
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(connection,statement,resultSet);
		}
	}
}