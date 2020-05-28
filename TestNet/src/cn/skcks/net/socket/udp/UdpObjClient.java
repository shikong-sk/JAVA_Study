package cn.skcks.net.socket.udp;

import java.io.*;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;

/*
    Client 引用类型 发送端

    使用 DatagramSocket 指定端口 创建发送端
    准备数据 将引用类型数据 转换为 字节数组
    封装为 DatagramPacket 数据包，指定目的地
    发送数据包 send(DatagramPacket dataPacket)
    释放资源
 */
public class UdpObjClient {
    public static void main(String[] args) {
        System.out.println("=========== 发送方 ===========");

        try {

            // 创建 datagramSocket
            DatagramSocket datagramSocket = new DatagramSocket(5666);

            // 要发送的数据

            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(new BufferedOutputStream(byteArrayOutputStream));

            ObjClass objClass = new ObjClass("时空","时空旅行者 666");
            objectOutputStream.writeObject(objClass);

            objectOutputStream.flush();

            byte[] data = byteArrayOutputStream.toByteArray();

            // 封装 DatagramPacket 数据包，需要指定目标地址
            InetSocketAddress inetSocketAddress = new InetSocketAddress("localhost",6555);
            DatagramPacket datagramPacket = new DatagramPacket(
                    data,
                    0,
                    data.length,
                    inetSocketAddress
            );


            System.out.println("========== 发送数据 ==========");
            System.out.println("目标 => " + inetSocketAddress.getHostString() + ":" + inetSocketAddress.getPort());
            // 发送数据包
            datagramSocket.send(datagramPacket);

            System.out.println("========== 发送完成 ==========");

            // 释放资源
            datagramSocket.close();


        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
