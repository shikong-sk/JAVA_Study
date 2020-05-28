package cn.skcks.net;

import java.net.MalformedURLException;
import java.net.URL;

/*
    URL
    统一资源定位器

    协议 + 域名|计算机名|IP + 端口 + 请求资源
 */
public class TestURL {
    public static void main(String[] args) {
        try {
            URL url = new URL("https://www.baidu.com:80/index.php?tn=mswin_oem#kw");

            System.out.println("协议\t\t：" + url.getProtocol());
            System.out.println("域名|IP\t\t：" + url.getHost());
            System.out.println("端口\t\t：" + url.getPort());
            System.out.println("请求资源\t：" + url.getFile());
            System.out.println("请求资源\t：" + url.getPath());

            System.out.println("参数\t\t：" + url.getQuery());
            System.out.println("锚点\t\t：" + url.getRef());
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }
}
