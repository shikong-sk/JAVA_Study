package cn.skcks.oop;

/*
 * 自动装箱、拆箱 
 */
public class TestAutoBox {
	public static void main(String[] args) {
		Integer aInteger = 234; // 自动装箱 ： Integer aInteger = Integer.valueOf(234);
		
		int b = aInteger; // 自动拆箱 ： int b = aInteger.intValue();
		
		Integer cInteger = null;
//		int d = cInteger; // 自动调用了 c.intValue();
		int d;
		if(cInteger != null)
		{
			d = cInteger;
		}
		
		/*
		 * 缓存[-128,127]之间的数字，实际就是系统初始化时生成了一个[-128,127]的cache数组
		 * 调用valueOf时，如果在缓存范围内则直接取值
		 * 否则创建一个新的Integer对象
		 */
		
		Integer eInteger = 1234;
		Integer fInteger = 1234;
		System.out.println(eInteger == fInteger); // false 1234不在缓存范围内，新建了一个对象
		System.out.println(eInteger.equals(fInteger)); // true
		
		System.out.println("#########################");
		Integer gInteger = -128;
		Integer hInteger = -128;
		System.out.println(gInteger == hInteger); // true -128在缓存范围内,直接从cache数组取值
		System.out.println(gInteger.equals(hInteger)); // true
		
	}
}
