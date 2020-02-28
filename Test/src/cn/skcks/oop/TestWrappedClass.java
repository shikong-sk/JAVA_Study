package cn.skcks.oop;

/*
 * 包装类
 */
public class TestWrappedClass {
	public static void main(String[] args) {
		/*
		 * 基本数据类型转包装类
		 */
		Integer a = new Integer(10);
		Integer b = Integer.valueOf(20);
		
		System.out.println(a);
		System.out.println(b);
		
		/*
		 * 包装类转基本数据类型
		 */
		
		int c = a.intValue();
		double d = b.doubleValue();
		
		System.out.println(c);
		System.out.println(d);
		
		/*
		 * 字符串转包装类
		 * （不能含有0-9以外的字符）
		 */
		Integer e = new Integer("-999");
		Integer f = Integer.parseInt("1000");
		
		System.out.println(e);
		System.out.println(f);
		
		/*
		 * 包装类转字符串
		 */
		String str= f.toString();
		
		System.out.println(str);
		
		/*
		 * 常见的常量
		 */
		System.out.println("int 类型的最大值：" + Integer.MAX_VALUE);
		System.out.println("int 类型的最小值：" + Integer.MIN_VALUE);
	}
}
