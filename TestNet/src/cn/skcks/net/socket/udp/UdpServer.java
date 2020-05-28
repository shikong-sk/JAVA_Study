package cn.skcks.net.socket.udp;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
import java.net.SocketException;

/*
    Server 接收端

    使用 DatagramSocket 指定端口 创建接收端
    准备容器 封装为 DatagramPacket 用来接收数据包
    阻塞式接收数据包 receive(DatagramPacket dataPacket)
    分析数据
        byte[] getData()、getLength()
    释放资源
 */
public class UdpServer {
    public static void main(String[] args) {
        System.out.println("=========== 接收方 ===========");

        try {
            // 创建 datagramSocket
            DatagramSocket datagramSocket = new DatagramSocket(6555);

            // 准备接收容器 DatagramPacket 接收 数据包
            byte[] data = new byte[(576-8-20)];
            DatagramPacket datagramPacket = new DatagramPacket(data,0,data.length);

            // 阻塞式接收数据
            datagramSocket.receive(datagramPacket);


            // 分析数据
            data = datagramPacket.getData();
            int len = datagramPacket.getLength();

            System.out.println("来自： " + ((InetSocketAddress) datagramPacket.getSocketAddress()).getHostName() + " 的信息");
            System.out.println(new String(data,0,len));

            // 释放资源
            datagramSocket.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
