package cn.skcks.net.socket.udp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
import java.net.SocketException;
import java.nio.charset.StandardCharsets;

/*
    Client 多次交流 接收发送二合一

    使用 DatagramSocket 指定端口 创建发送端
    准备数据 转换为 字节数组
    封装为 DatagramPacket 数据包，指定目的地
    发送数据包 send(DatagramPacket dataPacket)
    释放资源
 */
public class UdpTalkCore implements Runnable {
    static private DatagramSocket datagramSocket;
    static int port;
    static String target;
    static int targetPort;
    static private volatile boolean run = false;
    static private BufferedReader bufferedReader;

    public UdpTalkCore(int port, String target, int targetPort) {
        try {
            UdpTalkCore.target = target;
            UdpTalkCore.targetPort = targetPort;
            UdpTalkCore.port = port;
            datagramSocket = new DatagramSocket(UdpTalkCore.port);


        } catch (SocketException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        run = true;

        try {
            Thread send = new Thread(new Send());
            send.start();
            Thread receive = new Thread(new Receive());
            receive.start();
            while (true) {
                if (!run && !send.isAlive() && !receive.isAlive()) {
                    // 释放资源
                    datagramSocket.close();
                    break;
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    static class Receive implements Runnable {

        @Override
        public void run() {
            try {
                while (run) {
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

                    synchronized ((Boolean)run) {
                        if (string.equals("!exit") || string.equals("!q")) {
                            run = false;
                            return;
                        }
                    }
                    System.out.println("来自： " + inetSocketAddress.getHostString() + ":" + inetSocketAddress.getPort() + " 的信息：");
                    System.out.println(string);
                    System.out.println("==============================");
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    static class Send implements Runnable {
        @Override
        public void run() {
            try {
                synchronized (this) {
                    while (run) {
                        bufferedReader = new BufferedReader(new InputStreamReader(System.in));
                        String string = bufferedReader.readLine();

                        byte[] data = string.getBytes(StandardCharsets.UTF_8);

                        // 封装 DatagramPacket 数据包，需要指定目标地址
                        InetSocketAddress inetSocketAddress = new InetSocketAddress(target, targetPort);
                        DatagramPacket datagramPacket = new DatagramPacket(
                                data,
                                0,
                                data.length,
                                inetSocketAddress
                        );

                        System.out.println("目标 => " + inetSocketAddress.getHostString() + ":" + inetSocketAddress.getPort());
                        // 发送数据包
                        datagramSocket.send(datagramPacket);

                        System.out.println("==============================");

                        synchronized ((Boolean)run) {
                            if (string.equals("!exit") || string.equals("!q")) {
                                run = false;
                                DatagramPacket reSend = new DatagramPacket(data, 0, data.length, new InetSocketAddress("127.0.0.1", port));
                                datagramSocket.send(reSend);
                                return;
                            }
                        }
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

}
