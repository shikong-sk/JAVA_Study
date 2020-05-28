package cn.skcks.net;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;

/*
    爬虫原理
 */
public class TestSpider_2 {
    public static void main(String[] args) {
        try {
            // 获取URL
            URL url = new URL("https://www.dianping.com");

            // 伪装
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();

            httpURLConnection.setRequestMethod("GET");
            httpURLConnection.setRequestProperty("User-Agent","Mozilla/5.0 (Windows NT 10.0; Win64; x64; rv:76.0) Gecko/20100101 Firefox/76.0");

            // 下载
            InputStream inputStream = httpURLConnection.getInputStream();

            try(BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, StandardCharsets.UTF_8)))
            {
                String string;

                while ((string = bufferedReader.readLine()) != null)
                {
                    System.out.println(string);
                }
            }

            // 爬虫后续 分析、处理
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
