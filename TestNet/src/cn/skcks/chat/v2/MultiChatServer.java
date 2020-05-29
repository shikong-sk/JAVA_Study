package cn.skcks.chat.v2;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.atomic.AtomicBoolean;

/*
    在线聊天室：多人服务端
    多人聊天 可收发多条信息
 */
public class MultiChatServer {
    static volatile AtomicBoolean serverRun = new AtomicBoolean(true);

    public static void main(String[] args) {
        // ServerSocket 创建服务器
        try {

            System.out.println("创建服务器");
            ServerSocket server = new ServerSocket(6666);


            while (serverRun.get()) {
                // 阻塞式等待连接
                Socket client = server.accept();

                System.out.println("连接已建立");

                new Thread(() -> {
                    try {
                        boolean run = true;
                        // 接收信息
                        DataInputStream dataInputStream = new DataInputStream(new BufferedInputStream(client.getInputStream()));
                        DataOutputStream dataOutputStream = new DataOutputStream(new BufferedOutputStream(client.getOutputStream()));

                        while (run) {
                            String msg = "";
                            try {
                                msg = dataInputStream.readUTF();
                            } catch (Exception e) {
//                                e.printStackTrace();
                                break;
                            }

                            switch (msg) {
                                case "!q":
                                    run = false;
                                    break;
                                case "!serverDown":
                                    serverRun.set(false);
                                    break;
                            }

                            // 发送信息
                            dataOutputStream.writeUTF(msg);
                            dataOutputStream.flush();
                        }

                        // 释放资源
                        dataOutputStream.close();
                        dataInputStream.close();
                        client.close();
                    } catch (Exception e) {

                        e.printStackTrace();
                    }

                }).start();


            }

            server.close();


        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
