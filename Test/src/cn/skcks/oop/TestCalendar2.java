package cn.skcks.oop;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/*
 * 可视化日历
 */
public class TestCalendar2 {
	public static void main(String[] args) throws ParseException {
		String str = "2020-04-07";
		
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		
		Date date = df.parse(str);
		
		Calendar cal = new GregorianCalendar();
		cal.setTime(date);
		
		System.out.println("日\t一\t二\t三\t四\t五\t六");
	
		cal.set(Calendar.DAY_OF_MONTH, 1);
		
		int maxDay = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
		
		for(int i = 0;i < cal.get(Calendar.DAY_OF_WEEK)-1;i++)
		{
			System.out.print("\t");
		}
		
		for (int i = 1; i <= maxDay ; i++) {
			
			System.out.print(
				cal.get(Calendar.DAY_OF_MONTH) < 10 ?
					" "+cal.get(Calendar.DAY_OF_MONTH)+"\t":
					cal.get(Calendar.DAY_OF_MONTH)+"\t"
			);
			
			if(cal.get(Calendar.DAY_OF_WEEK) == 7)
			{
				System.out.print("\n");
			}
			
			cal.add(Calendar.DAY_OF_MONTH, 1);
		}
		
	}
}
