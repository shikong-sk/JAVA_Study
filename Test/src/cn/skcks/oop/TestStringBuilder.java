package cn.skcks.oop;

/*
 * StringBuilder、StringBuffer 可变字符序列
 */
public class TestStringBuilder {
	public static void main(String[] args) {
		
		/*
		 * StringBuilder 线程不安全，效率高
		 */
		StringBuilder stringBuilder = new StringBuilder("123456");
		
		/*
		 * StringBuffer 线程安全，效率低
		 */
		StringBuffer stringBuffer = new StringBuffer("123456");
		
		System.out.println(Integer.toHexString(stringBuilder.hashCode()));
		System.out.println(stringBuilder);
		
		stringBuilder.setCharAt(1, '二');
		
		System.out.println(Integer.toHexString(stringBuilder.hashCode()));
		System.out.println(stringBuilder);
		
		System.out.println(Integer.toHexString(stringBuffer.hashCode()));
		System.out.println(stringBuffer);
		
		stringBuffer.setCharAt(1, '二');
		
		System.out.println(Integer.toHexString(stringBuffer.hashCode()));
		System.out.println(stringBuilder);
	}
}
