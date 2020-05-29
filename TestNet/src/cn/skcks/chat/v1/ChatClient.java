package cn.skcks.chat.v1;

import java.io.*;
import java.net.Socket;

/*
    在线聊天室：客户端
 */
public class ChatClient {
    public static void main(String[] args) {
        try {
            Socket client = new Socket("localhost",6666);

            // 发送消息
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            String msg = "";
            msg = bufferedReader.readLine();

            DataOutputStream dataOutputStream = new DataOutputStream(new BufferedOutputStream(client.getOutputStream()));
            dataOutputStream.writeUTF(msg);
            dataOutputStream.flush();

            // 接收消息
            DataInputStream dataInputStream = new DataInputStream(new BufferedInputStream(client.getInputStream()));
            String data = dataInputStream.readUTF();
            System.out.println(data);

            // 释放资源
            dataInputStream.close();
            dataOutputStream.close();
            client.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
