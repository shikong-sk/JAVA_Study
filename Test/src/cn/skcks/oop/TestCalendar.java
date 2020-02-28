package cn.skcks.oop;

import java.util.Calendar;
import java.util.GregorianCalendar;

/*
 * 日期类
 * Calendar 构造类 
 * GregorianCalendar 实现类
 */
public class TestCalendar {
	public static void main(String[] args) {
		// 月份格式 0-11 
		// 星期格式  1-6 (1:周日 ... 7:周六)
		
		/*
		 * 获取日期的相关元素
		 */
		Calendar calendar = new GregorianCalendar(2020,1,28,23,59,00);
		
		System.out.println(calendar);

		int year = calendar.get(Calendar.YEAR);
		System.out.println(year);
		
		int month = calendar.get(Calendar.MONTH);
		System.out.println(month);
		
		int day = calendar.get(Calendar.DATE);
		System.out.println(day);
		
		int weekday = calendar.get(Calendar.DAY_OF_WEEK);
		System.out.println(weekday);
		
		/*
		 * 设置日期的相关元素
		 */
		Calendar calendar2 = new GregorianCalendar();
		System.out.println(calendar2);
		
		calendar2.set(Calendar.YEAR, 1999);
		System.out.println(calendar2);
		System.out.println(calendar2.get(Calendar.MONTH));
		System.out.println(calendar2.get(Calendar.DATE));
		
		/*
		 * 日期的计算
		 */
		
	}
}
