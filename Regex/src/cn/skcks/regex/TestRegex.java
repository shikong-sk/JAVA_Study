package cn.skcks.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
	JAVA 正则匹配
 */
public class TestRegex {
	public static void main(String[] args) {
		// 匹配字符串是否符合 正则表达式 \w+
		String string = "shi_kong.123";

		// 创建 表达式 对象
		Pattern pattern = Pattern.compile("\\w+");

		// 创建 Matcher 匹配 对象
		Matcher matcher = pattern.matcher(string);

		// 匹配整个字符串是否符合
		System.out.println(matcher.matches());
		System.out.println();

		// 复位游标
		matcher.reset();

		// 查找与表达式匹配的下一个子序列
		while(matcher.find())
		{
			// 获取匹配的子序列
			System.out.println(matcher.group());
		}

	}
}