package cn.skcks.oop;

public class TestString {
	public static void main(String[] args) {
		String str1 = "abc"; // String 为不可变字符串
		String str2 = "abc"; // 自动存入常量池
		String str3 = new String("abc"); // 独立的不同的对象
		
		System.out.println(str1 == str2);
		System.out.println(str1 == str3); // str1 和 str3 不是同一个对象
		
		System.out.println(str3.equals(str1)); // 通常使用 equals 比较字符串
		
		String s1 = "core Java ";
		String s2 = "Core Java ";
		
		System.out.println(s1.charAt(0)); // 提取下标为 0 的字符
		System.out.println(s1.equals(s2)); // 比较字符串是否相等
		System.out.println(s1.equalsIgnoreCase(s2)); // 比较字符串是否相等（忽略大小写）
		
		System.out.println(s1.indexOf("Java")); // 查找字符串是否包含 Java ,有则返回查找到的字符串的第一个字符的下标
		System.out.println(s1.indexOf("Shikong"));
		
		String s = s1.replace(" ", "&"); // 将字符串中的空格替换为 &
		
		System.out.println(s);
		
		System.out.println(s1.startsWith("core")); // 是否以 core 开头
		System.out.println(s1.endsWith("shikong")); // 是否以 shikong 结尾
		
		s = s1.substring(5); // 提取子字符串，从下标为5开始到字符串结尾为止
		System.out.println(s);
		
		s = s1.substring(5,8); // 提取子字符串从下标5到8-1 (不包括8) 范围：[5,8)
		System.out.println(s);
		
		s = s1.trim(); // 去除字符串首尾两边的空格
		System.out.println(s);
	}
}
