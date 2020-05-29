package cn.skcks.chat.v1;

import java.io.*;
import java.net.Socket;

/*
    在线聊天室：客户端
    可收发多条信息
 */
public class MultiChatClient {
    public static void main(String[] args) {
        try {
            boolean run = true;
            Socket client = new Socket("localhost",6666);

            // 发送消息
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            DataOutputStream dataOutputStream = new DataOutputStream(new BufferedOutputStream(client.getOutputStream()));
            DataInputStream dataInputStream = new DataInputStream(new BufferedInputStream(client.getInputStream()));

            while(run)
            {
                String msg = "";
                msg = bufferedReader.readLine();

                dataOutputStream.writeUTF(msg);
                dataOutputStream.flush();

                if(msg.equals("!q"))
                {
                    run = false;
                }

                // 接收消息
                String data = dataInputStream.readUTF();
                System.out.println(data);
            }

            // 释放资源
            dataInputStream.close();
            dataOutputStream.close();
            client.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
