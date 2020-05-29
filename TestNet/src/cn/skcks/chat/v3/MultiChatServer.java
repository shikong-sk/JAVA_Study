package cn.skcks.chat.v3;

import org.jetbrains.annotations.NotNull;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.atomic.AtomicBoolean;

/*
    在线聊天室：多人服务端 封装多线程
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

                new Thread(new Service(client)).start();

            }

            server.close();


        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // 客户连接服务类
    static class Service implements Runnable{
        Socket client;
        DataInputStream dataInputStream;
        DataOutputStream dataOutputStream;
        private volatile boolean run;

        @Override
        public void run() {
            while (run){
                String string = receive();
                if(!string.isEmpty())
                {
                    send(string);
                }
                if(string.equals("!q"))
                {
                    run = false;
                }
            }
        }

        public Service(Socket client) {
            try {
                this.client = client;
                dataInputStream = new DataInputStream(new BufferedInputStream(this.client.getInputStream()));
                dataOutputStream = new DataOutputStream(new BufferedOutputStream(this.client.getOutputStream()));
                run = true;
            } catch (Exception e) {
                release();
            }
        }

        // 接收信息
        private String receive() {
            String data = "";
            try {
                data = dataInputStream.readUTF();
            } catch (Exception e) {
                e.printStackTrace();
                System.out.println("\033[31m [-] \t 接收信息时出现错误 \033[0m");
                release();
            }
            return data;
        }

        // 发送信息
        private void send(String data) {
            try {
                dataOutputStream.writeUTF(data);
                dataOutputStream.flush();
            } catch (IOException e) {
                System.out.println("\033[31m [-] \t 发送信息时出现错误 \033[0m");
                release();
            }

        }

        private void release() {
            // 释放资源
            try {
                Utils.closeAll(dataOutputStream, dataInputStream, client);
                run = false;
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
