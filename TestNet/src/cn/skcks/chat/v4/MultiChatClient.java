package cn.skcks.chat.v4;

import org.jetbrains.annotations.NotNull;

import java.io.*;
import java.net.Socket;
import java.util.concurrent.atomic.AtomicBoolean;

/*
    在线聊天室：多人客户端 封装多线程 群聊
    多人聊天 可收发多条信息
 */
public class MultiChatClient {
    static volatile AtomicBoolean run = new AtomicBoolean();
    public static void main(String[] args) {
        System.out.println("\033[94m [ * ] \t 启动客户端 \033[0m");
        try {

            System.out.print("\033[93m [ ! ] \t 请输入用户名: \033[0m");
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            String user = bufferedReader.readLine();

            Socket client = new Socket("localhost", 6666);
            System.out.println("\033[94m [ * ] \t 已连接到服务器：" + client.getInetAddress() + ":" + client.getPort()+ " \033[0m");

            new Thread(new Send(client,user),"SendService").start();
            new Thread(new Receive(client),"ReceiveService").start();

        } catch (Exception e) {
            System.out.println("\033[31m [ - ] \t 与服务器连接失败 \033[0m");
        }
    }

    // 发送
    static class Send implements Runnable {
        Socket client;
        BufferedReader bufferedReader;
        DataOutputStream dataOutputStream;
        private String user;

        public Send(Socket client,String user) {
            try {
                this.client = client;
                this.user = user;
                dataOutputStream = new DataOutputStream(new BufferedOutputStream(client.getOutputStream()));
                bufferedReader = new BufferedReader(new InputStreamReader(System.in));
                send(user);
            } catch (Exception e) {
                System.out.println("\033[31m [ - ] \t 与服务器连接失败 \033[0m");
                release();
            }
        }

        @Override
        public void run() {
            run.set(true);

            while (run.get()) {
                String msg = getInput();
                if (msg != null && !msg.isEmpty()) {
                    if(msg.equals("!q"))
                    {
                        run.set(false);
                    }
                    send(msg);
                }

            }
            release();

        }

        public String getUser() {
            return user;
        }

        public void setUser(String user) {
            this.user = user;
        }

        private void send(String data) {
            try {
                dataOutputStream.writeUTF(data);
                dataOutputStream.flush();
            }catch (Exception e){
                System.out.println("\033[31m [ - ] \t 信息发送失败 \033[0m");
                release();
            }
        }

        private String getInput() {
            String msg = "";
            try {
                msg = bufferedReader.readLine();
            } catch (IOException e) {
                System.out.println("\033[31m [ - ] \t 获取输入信息失败 \033[0m");
                release();
            }
            return msg;
        }

        private void release() {
            // 释放资源
            try {
                System.out.println("============  已断开连接  ============");
                Utils.closeAll(dataOutputStream, client);
                run.set(false);
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

    // 接收
    static class Receive implements Runnable {
        Socket client;
        DataInputStream dataInputStream;

        @Override
        public void run() {
            run.set(true);
            while (run.get()){
                String msg = receive();
                if(!msg.isEmpty() && run.get())
                {
                    System.out.println(msg);
                }
            }
            receive();
        }

        public Receive(Socket client) {
            try {
                this.client = client;
                dataInputStream = new DataInputStream(new BufferedInputStream(this.client.getInputStream()));
            } catch (Exception e) {
                System.out.println("\033[31m [ - ] \t 与服务器连接失败 \033[0m");
                release();
            }
        }

        // 接收信息
        private String receive() {
            String data = "";
            try {
                data = dataInputStream.readUTF();
            } catch (Exception e) {
                if(run.get())
                {
                    System.out.println("\033[31m [ - ] \t 接收信息时出现错误 \033[0m");
                }
                release();
            }
            return data;
        }

        private void release() {
            // 释放资源
            try {
                if(run.get())
                {
                    System.out.println("===== 已断开连接 =====");
                }
                Send.Utils.closeAll(dataInputStream, client);
                run.set(false);
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
