package cn.skcks.net.socket.udp;

import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.ObjectInputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;

/*
    Server 文件 接收端

    使用 DatagramSocket 指定端口 创建接收端
    准备容器 封装为 DatagramPacket 用来接收数据包
    阻塞式接收数据包 receive(DatagramPacket dataPacket)
    分析数据 将字节数组 还原为 文件
        byte[] getData()、getLength()
    释放资源
 */
public class UdpFileServer {
    public static void main(String[] args) {
        System.out.println("=========== 接收方 ===========");

        try {
            // 创建 datagramSocket
            DatagramSocket datagramSocket = new DatagramSocket(6555);

            // 准备接收容器 DatagramPacket 接收 数据包
            byte[] data = new byte[1024 * 20]; // 1k * 20
            DatagramPacket datagramPacket = new DatagramPacket(data,0,data.length);

            // 阻塞式接收数据
            datagramSocket.receive(datagramPacket);


            // 分析数据
            data = datagramPacket.getData();
            int len = datagramPacket.getLength();

            System.out.println("来自： " + ((InetSocketAddress) datagramPacket.getSocketAddress()).getHostName() + " 的文件");
            System.out.println("大小 => " + len + " 字节");

            FileUtils.byteArrayToFile(data,"io/dest.png");

            // 释放资源
            datagramSocket.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
