package cn.skcks.oop;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/*
 * 日期类
 * Calendar 构造类 
 * GregorianCalendar 实现类
 */
public class TestCalendar {
	public static void main(String[] args) {
		// 月份格式 0-11
		// 星期格式 1-6 (1:周日 ... 7:周六)

		/*
		 * 获取日期的相关元素
		 */
		Calendar calendar = new GregorianCalendar(2020, 1, 28, 23, 59, 00);

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
		Calendar calendar3 = new GregorianCalendar();
		calendar3.add(Calendar.DATE, 100); // 100天后
		System.out.println(calendar3);

		calendar3.add(Calendar.YEAR, -1); // 1年前
		System.out.println(calendar3);

		/*
		 * 日期对象和时间对象的转换
		 */
		Date date = calendar3.getTime();
		Calendar calendar4 = new GregorianCalendar();
		calendar4.setTime(date);
		System.out.println(date);
		System.out.println(calendar4);

		/*
		 * 自定义格式化方法
		 */
		System.out.println(printCalendar(calendar4));

	}

	public static String printCalendar(Calendar calendar) {
		// 格式化输出
		int year = calendar.get(Calendar.YEAR);
		int month = calendar.get(Calendar.MONTH) + 1; // 0-11
		int date = calendar.get(Calendar.DATE);
		int weekday = calendar.get(Calendar.DAY_OF_WEEK) - 1;
		String weekDay[] = { "周日", "周一", "周二", "周三", "周四", "周五", "周六" };

		int hour = calendar.get(Calendar.HOUR_OF_DAY);
		int minute = calendar.get(Calendar.MINUTE);
		int second = calendar.get(Calendar.SECOND);

		return year + "年" + (month < 10 ? "0" + month : month) + "月" + (date < 10 ? "0" + date : date) + "日 "
				+ (hour < 10 ? "0" + hour : hour) + ":" + (minute < 10 ? "0" + minute : minute) + ":"
				+ (second < 10 ? "0" + second : second) + " " + weekDay[weekday];

	}
}
