package cn.skcks.orm.utils;

/*
	封装常用 字符串 操作
 */
public class StringUtils {

	// 首字母大写
	public static String firstChar2UpperCase(String str){
		return str.toUpperCase().substring(0,1) + str.substring(1);
	}
}