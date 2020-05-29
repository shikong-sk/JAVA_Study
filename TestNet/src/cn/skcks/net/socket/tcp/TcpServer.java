package cn.skcks.net.socket.tcp;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.net.ServerSocket;
import java.net.Socket;

/*
    TCP Server

    使用 ServerSocket 创建服务器
    阻塞式等待连接 accept
    输入输出流操作
    释放资源
 */
public class TcpServer {
    public static void main(String[] args) {
        try {
            // ServerSocket 创建服务器
            ServerSocket server = new ServerSocket(6666);
            // 阻塞式等待连接
            Socket client = server.accept();

            System.out.println("连接已建立");
            // 操作 输入输出流
            DataInputStream dataInputStream = new DataInputStream(new BufferedInputStream(client.getInputStream()));

            System.out.println(dataInputStream.readUTF());

            dataInputStream.close();
            client.close();
            server.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
