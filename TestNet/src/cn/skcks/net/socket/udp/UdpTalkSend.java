package cn.skcks.net.socket.udp;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
import java.net.SocketException;
import java.nio.charset.StandardCharsets;

/*
    信息发送
 */
public class UdpTalkSend implements Runnable {
    private DatagramSocket datagramSocket;
    private BufferedReader bufferedReader;
    String target;
    int targetPort;

    public UdpTalkSend(int port,String target,int targetPort) {
        try {
            this.target = target;
            this.targetPort = targetPort;
            this.datagramSocket = new DatagramSocket(port);
            this.bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        } catch (SocketException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        try {
            while (true) {

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

                if (string.equals("!exit") || string.equals("!q")) {
                    break;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        // 释放资源
        datagramSocket.close();
    }
}
