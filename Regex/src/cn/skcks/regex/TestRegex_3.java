package cn.skcks.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
	JAVA 正则匹配

	其他方法
 */
public class TestRegex_3 {
	public static void main(String[] args) {
		// 匹配字符串是否符合 正则表达式 \w+
		String string = "aa.-.11bb._.22cc.-.33";

		// 创建 表达式 对象
//		Pattern pattern = Pattern.compile("(\\.)");
		Pattern pattern = Pattern.compile("(?<=[a-z]{2}).*?(?=[0-9]{2})");

		// 创建 Matcher 匹配 对象
		Matcher matcher = pattern.matcher(string);

		// 替换
		string = matcher.replaceAll("*");
		System.out.println(string);

		// 字符串分割
		String[] stringArray =  string.split("(?<=[a-z]{2})(\\*)(?=[0-9]{2})");

		System.out.println();

		for (String tmp:stringArray) {
			System.out.println(tmp);
		}
	}
}