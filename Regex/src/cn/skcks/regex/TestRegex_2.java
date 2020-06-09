package cn.skcks.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
	JAVA 正则匹配

	分组处理
 */
public class TestRegex_2 {
	public static void main(String[] args) {
		// 匹配字符串是否符合 正则表达式 \w+
		String string = "aa.11bb.22cc.33";

		// 创建 表达式 对象
		Pattern pattern = Pattern.compile("([a-z]{2}).([0-9]{2})");

		// 创建 Matcher 匹配 对象
		Matcher matcher = pattern.matcher(string);

		// 查找与表达式匹配的下一个子序列 可指定起始位置
		while(matcher.find())
		{
			// 获取匹配的子序列
			System.out.println("group(0) => " + matcher.group());    // 相当于 group(0) 匹配整个表达式的子字符串
			System.out.println("group(1) => " + matcher.group(1));   // 匹配第一个分组
			System.out.println("group(2) => " + matcher.group(2));   // 匹配第二个分组
			System.out.println();
		}

	}
}