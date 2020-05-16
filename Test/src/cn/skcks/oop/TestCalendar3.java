package cn.skcks.oop;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;
import java.util.regex.Pattern;


/*
 * 可视化日历 v2.0
 */
public class TestCalendar3 {
	public static void main(String[] args) throws ParseException {
		String str = "2020-04-08";
		
		String format = "yyyy-MM-dd";
		String regex = "[0-9]{4}-[0-9]{1,2}-[0-9]{1,2}";
		DateFormat df = new SimpleDateFormat(format);
		
		System.out.print("请输入日期 (格式 : " + df.format(new Date()) + ") : ");
		
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		
		str = scanner.nextLine();
		
		while(!Pattern.matches(regex, str))
		{
			System.out.println("日期格式错误\n");
			System.out.print("请输入日期 (格式 : " + df.format(new Date()) + ") : ");
	
			scanner = new Scanner(System.in);
			str = scanner.nextLine();
		}
		
		Date date = df.parse(str);
		
		Calendar cal = new GregorianCalendar();
		cal.setTime(date);
		
		System.out.println(
				"\t\t     " + 
				cal.get(Calendar.YEAR) + " - " + (
				(
					cal.get(Calendar.MONTH) + 1) < 10 ?
						"0" + (cal.get(Calendar.MONTH) + 1):
						(cal.get(Calendar.MONTH) + 1)
				)
		);
		
		int now = cal.get(Calendar.DAY_OF_MONTH);
		int maxDay = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
		
		System.out.println("日\t一\t二\t三\t四\t五\t六");
	
		
		cal.set(Calendar.DAY_OF_MONTH, 1);
		
		for(int i = 0;i < cal.get(Calendar.DAY_OF_WEEK)-1;i++)
		{
			System.out.print("\t");
		}
		
		for (int i = 1; i <= maxDay ; i++) {
			
			if(cal.get(Calendar.DAY_OF_MONTH) < 10)
			{
				System.out.print(" ");
			}
			
			System.out.print(cal.get(Calendar.DAY_OF_MONTH));
			
			if(new Integer(cal.get(Calendar.DAY_OF_MONTH)).equals(now))
			{
				System.out.print("*");
			}
			
			System.out.print("\t");
			
			if(cal.get(Calendar.DAY_OF_WEEK) == 7)
			{
				System.out.print("\n");
			}
			
			cal.add(Calendar.DAY_OF_MONTH, 1);
		}
		
	}
}
