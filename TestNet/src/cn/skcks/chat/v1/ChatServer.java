package cn.skcks.chat.v1;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/*
    在线聊天室：服务端
 */
public class ChatServer {
    public static void main(String[] args) {
        // ServerSocket 创建服务器
        try {
            System.out.println("创建服务器");
            ServerSocket server = new ServerSocket(6666);

            // 阻塞式等待连接
            Socket client = server.accept();

            System.out.println("连接已建立");

            // 接收信息
            DataInputStream dataInputStream = new DataInputStream(new BufferedInputStream(client.getInputStream()));
            String msg = dataInputStream.readUTF();

            // 发送信息
            DataOutputStream dataOutputStream = new DataOutputStream(new BufferedOutputStream(client.getOutputStream()));
            dataOutputStream.writeUTF(msg);
            dataOutputStream.flush();

            // 释放资源
            dataOutputStream.close();
            dataInputStream.close();
            client.close();
            server.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
