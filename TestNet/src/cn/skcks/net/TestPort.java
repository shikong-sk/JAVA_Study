package cn.skcks.net;

import java.net.InetSocketAddress;

/*
    端口

    0 - 65535

    同一协议下端口不能冲突

    InetSocketAddress

    构造器
    new InetSocketAddress(IP|域名,端口);

    .getAddress()   返回获取到的 ip 地址
    .getHostName()      返回计算机名
    .getPort()          返回端口号
 */
public class TestPort {
    public static void main(String[] args) {
        InetSocketAddress inetSocketAddress = new InetSocketAddress("127.0.0.1",65535);
        InetSocketAddress inetSocketAddress2 = new InetSocketAddress("localhost",888);

        System.out.println(inetSocketAddress.getAddress());
        System.out.println(inetSocketAddress.getHostName());
        System.out.println(inetSocketAddress.getPort());

        System.out.println("========================================");

        System.out.println(inetSocketAddress2.getAddress());
        System.out.println(inetSocketAddress2.getHostName());
        System.out.println(inetSocketAddress2.getPort());
    }
}
