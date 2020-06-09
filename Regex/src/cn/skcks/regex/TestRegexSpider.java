package cn.skcks.regex;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;

import java.net.URL;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TestRegexSpider {
	public static void main(String[] args) {
		List<String[]> target = getMatcherSubstring("https://www.zdfans.com", "utf-8", "(?<=<a href=\")(.*?)(?=\")(?:.*?)(?<=<img src=\")(.*?)(?=\")");

		for (String[] t : target) {
			System.out.println(Arrays.toString(t));
		}
	}

	public static List<String[]> getMatcherSubstring(String url, String charset, String regex) {
		List<String[]> list = new ArrayList<>();
		String content = getContent(url, charset);

		// 创建 表达式 对象
		Pattern pattern = Pattern.compile(regex);

		// 创建 Matcher 匹配 对象
		Matcher matcher = pattern.matcher(content);

		// 查找与表达式匹配的下一个子序列 可指定起始位置
		while (matcher.find()) {
			// 获取匹配的子序列
			list.add(new String[]{url + matcher.group(1), url + matcher.group(2)});   // 获取匹配分组内容
		}

		return list;
	}

	public static String getContent(String url, String charset) {
		try {
			URL urlClass = new URL(url);

			HttpURLConnection connection = (HttpURLConnection) urlClass.openConnection();

			connection.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64; rv:77.0) Gecko/20100101 Firefox/77.0");

			BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(connection.getInputStream(), Charset.forName(charset)));

			String temp;
			StringBuilder res = new StringBuilder();
			while ((temp = bufferedReader.readLine()) != null) {
				res.append(temp).append("\r\n");
			}

			return res.toString();

		} catch (Exception e) {
			e.printStackTrace();
			return "";
		}
	}
}