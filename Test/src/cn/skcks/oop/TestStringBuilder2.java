package cn.skcks.oop;

/*
 * 可变字符序列的常用方法
 */
public class TestStringBuilder2 {
	public static void main(String[] args) {
		
		StringBuilder stringBuilder = new StringBuilder();
		
		for (int i = 0; i < 26; i++) {
			stringBuilder.append((char)('a' + i));
		}
		System.out.println(stringBuilder);
		
		stringBuilder.reverse();
		System.out.println(stringBuilder);
		
		stringBuilder.setCharAt(0, '空');
		System.out.println(stringBuilder);
		
		stringBuilder.insert(0, '时');
		System.out.println(stringBuilder);
		
		/*
		 * 链式调用
		 * 本质是 return this , 将自己返回了
		 */
		stringBuilder.insert(2, '旅').insert(3, '行').insert(4, '者'); 
		System.out.println(stringBuilder);
		
		stringBuilder.delete(2, 5);
		System.out.println(stringBuilder);
	}
}
