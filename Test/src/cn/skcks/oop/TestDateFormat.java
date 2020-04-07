package cn.skcks.oop;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.sun.org.apache.bcel.internal.generic.NEW;


/*
 * 时间对象与字符串之间的转换
 * DateFormat抽象类 和 SimpleDateFormat实现类的使用
 */
public class TestDateFormat {
	public static void main(String[] args) throws ParseException {
		
		/*
		 * 时间对象转字符串
		 */
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		
		String str = df.format(new Date(4000000));
		System.out.println(str);
		
		str = df.format(new Date());
		System.out.println(str);
		
		/*
		 * 字符串转时间对象
		 */
		
		Date date = df.parse("2020-02-29 00:00:00");
		
		System.out.println(date);
		
		/*
		 * 	其他格式字符
		 */
		DateFormat df2 = new SimpleDateFormat("D"); // 当前日期为当前年份的第几天
		System.out.println(df2.format(new Date()));
		
		System.out.println(df.format(new Date()));
	}
}
