package cn.skcks.net;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.StandardCharsets;

/*
    爬虫原理
 */
public class TestSpider {
    public static void main(String[] args) {
        try {
            // 获取URL
            URL url = new URL("https://www.jd.com");
//            URL url = new URL("https://www.dianping.com");

            // 下载
            InputStream inputStream = url.openStream();

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
