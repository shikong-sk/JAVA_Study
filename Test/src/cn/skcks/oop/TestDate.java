package cn.skcks.oop;

import java.util.Date;

/*
 * Date 类的常见用法
 */
public class TestDate {
	public static void main(String[] args) {
		Date date = new Date(2000);
		
		System.out.println(date);
		System.out.println(date.getTime());
		
		Date date2 = new Date();
		
		System.out.println(date2);
		System.out.println(date2.getTime());
		
		System.out.println(date.before(date2));// 测试 date 是否在 date2 之前
		System.out.println(date.after(date2)); // 测试 date 是否在 date2 之后
		
		
		// 日期处理推荐使用 Canlendar 日期类
		// 被废弃的方法
		@SuppressWarnings("deprecation")
		Date date3 = new Date(2020-1900,02-1,28); // 2020.02.28
		System.out.println(date3);
	}
}
