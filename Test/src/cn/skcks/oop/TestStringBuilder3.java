package cn.skcks.oop;

/*
 * 可变字符串和不可变字符串序列使用的陷阱
 */
public class TestStringBuilder3 {
	public static void main(String[] args) {
		
		/*
		 * String 进行字符串的拼接
		 */
		String str = "";
		long startFree = Runtime.getRuntime().freeMemory();
		long startTime = System.currentTimeMillis();
		for (int i = 0; i < 5000; i++) {
			str += i; // 相当于产生了 10000 个对象 new String(str + new String(i.toString()))
		}
		long endFree = Runtime.getRuntime().freeMemory();
		long endTime = System.currentTimeMillis();
		System.out.println("String 占用内存：" + (startFree - endFree) / 1024 / 1024D + 'M' );
		System.out.println("String 耗时：" + (endTime - startTime) + " ms");
		
		/*
		 * StringBuilder 进行字符串的拼接
		 */
		StringBuilder str2 = new StringBuilder("");
		long startFree2 = Runtime.getRuntime().freeMemory();
		long startTime2 = System.currentTimeMillis();
		for (int i = 0; i < 5000 * 100; i++) { // 效率相差 N 倍
			str2.append(i);
		}
		long endFree2 = Runtime.getRuntime().freeMemory();
		long endTime2 = System.currentTimeMillis();
		System.out.println("StringBuilder 占用内存：" + (startFree2 - endFree2) / 1024 / 1024D + 'M' );
		System.out.println("StringBuilder 耗时：" + (endTime2 - startTime2) + " ms");
		
	}
}
