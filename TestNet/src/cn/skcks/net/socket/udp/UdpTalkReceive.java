package cn.skcks.net.socket.udp;

import java.io.BufferedReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
import java.net.SocketException;
import java.nio.charset.StandardCharsets;

/*
    信息回复
 */
public class UdpTalkReceive implements Runnable {
    private DatagramSocket datagramSocket;
    int rePort;

    public UdpTalkReceive(int port) {
        try {
            this.datagramSocket = new DatagramSocket(port);
            this.rePort = -1;
        } catch (SocketException e) {
            e.printStackTrace();
        }
    }

    public UdpTalkReceive(int port,int rePort) {
        try {
            this.datagramSocket = new DatagramSocket(port);
            this.rePort = rePort;
        } catch (SocketException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        try {
            while (true) {

                // 准备接收容器 DatagramPacket 接收 数据包
                byte[] data = new byte[(576 - 8 - 20)];
                DatagramPacket datagramPacket = new DatagramPacket(data, 0, data.length);

                // 阻塞式接收数据
                datagramSocket.receive(datagramPacket);


                // 分析数据
                data = datagramPacket.getData();
                int len = datagramPacket.getLength();
                String string = new String(data, 0, len, StandardCharsets.UTF_8);
                InetSocketAddress inetSocketAddress = (InetSocketAddress) datagramPacket.getSocketAddress();

                if (string.equals("!exit") || string.equals("!q")) {
                    DatagramPacket reSend = new DatagramPacket(data,0,len,new InetSocketAddress(inetSocketAddress.getHostString(),rePort == -1?inetSocketAddress.getPort()+1:rePort));
                    datagramSocket.send(reSend);
                    break;
                }


                System.out.println("来自： " + inetSocketAddress.getHostString() + ":" + inetSocketAddress.getPort() + " 的信息：");
                System.out.println(string);
                System.out.println("==============================");
            }
            // 释放资源
            datagramSocket.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
