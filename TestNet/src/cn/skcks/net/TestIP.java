package cn.skcks.net;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Arrays;

/*
    IP

    getLocalHost 获取本机 ip 地址
    getByName 根据域名解析 ip 地址

    .getHostAddress()   返回获取到的 ip 地址
    .getHostName()      返回计算机名
 */
public class TestIP {
    public static void main(String[] args) {
        try {

            // 使用 getLocalHost 创建 InetAddress 对象 获取本机
            InetAddress inetAddress = InetAddress.getLocalHost();

            System.out.println(inetAddress.getHostAddress());

            System.out.println(Arrays.toString(inetAddress.getAddress()));

            System.out.println(inetAddress.getCanonicalHostName());

            System.out.println("========================================");

            // getByName 根据域名解析 ip 地址
            inetAddress = InetAddress.getByName("baidu.com");
            System.out.println(inetAddress.getHostAddress());
            System.out.println(inetAddress.getHostName());


        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }
}
