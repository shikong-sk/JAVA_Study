package cn.skcks.chat.v1;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/*
    在线聊天室：服务端
    可收发多条信息
 */
public class MultiChatServer {
    public static void main(String[] args) {
        // ServerSocket 创建服务器
        try {
            boolean run = true;

            System.out.println("创建服务器");
            ServerSocket server = new ServerSocket(6666);

            // 阻塞式等待连接
            Socket client = server.accept();

            System.out.println("连接已建立");

            // 接收信息
            DataInputStream dataInputStream = new DataInputStream(new BufferedInputStream(client.getInputStream()));
            DataOutputStream dataOutputStream = new DataOutputStream(new BufferedOutputStream(client.getOutputStream()));

            while (run)
            {
                String msg = dataInputStream.readUTF();
                if(msg.equals("!q"))
                {
                    run = false;
                }
                // 发送信息
                dataOutputStream.writeUTF(msg);
                dataOutputStream.flush();
            }


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
