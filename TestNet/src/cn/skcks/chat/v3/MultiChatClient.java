package cn.skcks.chat.v3;

import org.jetbrains.annotations.NotNull;

import java.io.*;
import java.net.Socket;

/*
    在线聊天室：多人客户端 封装多线程
    多人聊天 可收发多条信息
 */
public class MultiChatClient {
    public static void main(String[] args) {
        try {
            boolean run = true;
            Socket client = new Socket("localhost", 6666);

            // 发送消息
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            DataOutputStream dataOutputStream = new DataOutputStream(new BufferedOutputStream(client.getOutputStream()));
            DataInputStream dataInputStream = new DataInputStream(new BufferedInputStream(client.getInputStream()));

            while (run) {
                String msg = "";
                msg = bufferedReader.readLine();

                dataOutputStream.writeUTF(msg);
                dataOutputStream.flush();

                if (msg.equals("!q")) {
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

    static class Send implements Runnable {
        Socket client;
        BufferedReader bufferedReader;
        DataInputStream dataInputStream;
        DataOutputStream dataOutputStream;

        public Send(Socket client) {
            try {
                this.client = client;
                dataOutputStream = new DataOutputStream(new BufferedOutputStream(client.getOutputStream()));
                bufferedReader = new BufferedReader(new InputStreamReader(System.in));
                dataInputStream = new DataInputStream(new BufferedInputStream(client.getInputStream()));
            } catch (Exception e) {
                release();
            }
        }

        @Override
        public void run() {

        }

        private void release() {
            // 释放资源
            try {
                Utils.closeAll(dataOutputStream, dataInputStream, client);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        public static class Utils {
            static void closeAll(Closeable @NotNull ... targets) {
                for (Closeable target : targets) {
                    if (target != null) {
                        try {
                            target.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
    }
}
