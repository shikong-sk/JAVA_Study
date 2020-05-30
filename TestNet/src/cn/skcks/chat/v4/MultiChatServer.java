package cn.skcks.chat.v4;

import org.jetbrains.annotations.NotNull;

import java.io.*;
import java.lang.reflect.Method;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;

/*
    在线聊天室：多人服务端 封装多线程 群聊
    多人聊天 可收发多条信息
 */
public class MultiChatServer {
    static volatile AtomicBoolean serverRun = new AtomicBoolean(true);
    private static final CopyOnWriteArrayList<Service> clientList = new CopyOnWriteArrayList<>();

    public static void main(String[] args) {
        // ServerSocket 创建服务器
        try {

            System.out.println("\033[94m [ * ] \t 服务器已开启 \033[0m");
            ServerSocket server = new ServerSocket(6666);


            while (serverRun.get()) {
                // 阻塞式等待连接
                Socket client = server.accept();

                Service service = new Service(client);
                clientList.add(service);    // 管理所有客户端

                new Thread(service).start();

            }

            server.close();


        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // 客户连接服务类
    static class Service implements Runnable {
        Socket client;
        DataInputStream dataInputStream;
        DataOutputStream dataOutputStream;
        private volatile boolean run;
        private String user;
        static Map<String, String> command = new HashMap<>();

        @Override
        public void run() {
            getOnlineUser();
            sendToGroup("\"" + getUser() + "\" 进入聊天室",true);
            while (run) {
                try {
                    String string = receive();
                    if (string != null && !string.isEmpty()) {
                        if (command.containsKey(string)) {
                            try {
                                this.getClass().getDeclaredMethod(command.get(string)).invoke(this);
                            } catch (Exception e) {
                                System.out.println("\033[31m [ - ] \t 参数错误 \033[0m");
                            }
                        } else {
//                            send(string);
                            sendToGroup(string,false);
                        }
                    }

                } catch (Exception e) {
                    System.out.println("\033[31m [ - ] \t 客户端连接中断 \033[0m");
                    release();
                }
            }
        }

        public Service(Socket client) {
            try {
                this.client = client;
                initCommand();
                dataInputStream = new DataInputStream(new BufferedInputStream(this.client.getInputStream()));
                dataOutputStream = new DataOutputStream(new BufferedOutputStream(this.client.getOutputStream()));
                this.user = receive();
                run = true;
                System.out.println("\033[32m [ * ] \t " + client.getInetAddress().getHostAddress() + ":" + client.getPort() + " - " + user + " 已连接 \033[0m");
            } catch (Exception e) {
                System.out.println("\033[31m [ - ] \t 与客户端连接失败 \033[0m");
                release();
            }
        }

        public String getUser() {
            return user;
        }

        // 接收信息
        private String receive() {
            String data = "";
            try {
                data = dataInputStream.readUTF();
            } catch (Exception e) {
                System.out.println("\033[31m [ - ] \t 接收信息时出现错误 \033[0m");
                release();
            }
            return data;
        }

        private void initCommand() {
            command.put("!q", "release");
            command.put("!online", "getOnlineUser");
            command.put("!h", "getHelp");
            command.put("!help", "getHelp");
        }

        private void getHelp(){
            StringBuilder help;
            help = new StringBuilder();
            help.append("\033[32m");
            help.append("=============  帮助菜单  =============").append("\n");
            help.append("!q             =>      退出程序").append("\n");
            help.append("!online        =>      查看在线用户").append("\n");
            help.append("!h 或 !help    =>      帮助菜单").append("\n");
            help.append("======================================").append("\n");
            help.append("当前用户名：\t").append(getUser()).append("\n");
            help.append("======================================").append("\n");
            help.append("\033[0m");
            send(help.toString());
        }

        protected void getOnlineUser() {
            send("当前在线用户( " + clientList.size() + " 人)：");
            StringBuilder userList = new StringBuilder();
            for (Service otherClient : clientList) {
                if(otherClient == this)
                {
                    userList.append("\033[94m").append(otherClient.getUser()).append(" (自己)\033[0m").append("、");
                }
                else{
                    userList.append(otherClient.getUser()).append("、");
                }
            }
            send(userList.replace(userList.length() - 1, userList.length(), "").toString());
        }

        // 发送信息
        private void send(String data) {
            try {
                dataOutputStream.writeUTF(data);
                dataOutputStream.flush();
            } catch (IOException e) {
                System.out.println("\033[31m [ - ] \t 发送信息时出现错误 \033[0m");
                release();
            }
        }

        // 群发信息
        private void sendToGroup(String data,Boolean isSystemMessage) {

            for (Service otherClient : clientList) {
                if (otherClient == this) {
                    continue;
                }
                if(isSystemMessage)
                {
                    otherClient.send(data);
                }
                else{
                    otherClient.send(user + " : " + data);
                }
            }

        }

        protected void release() {
            // 释放资源
            try {
                System.out.println("\033[32m [ * ] \t " + client.getInetAddress().getHostAddress() + ":" + client.getPort() + " - " + user + " 已断开连接 \033[0m");
                sendToGroup("\"" + getUser() + "\" 离开聊天室",true);
                Utils.closeAll(dataOutputStream, dataInputStream, client);
                clientList.remove(this);
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
