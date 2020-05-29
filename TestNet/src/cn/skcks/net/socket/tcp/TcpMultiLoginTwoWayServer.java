package cn.skcks.net.socket.tcp;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/*
    TCP MultiLoginTwoWayServer 多用户双向

    使用 ServerSocket 创建服务器
    阻塞式等待连接 accept
    输入输出流操作
    释放资源
 */
public class TcpMultiLoginTwoWayServer {
    public static void main(String[] args) {
        try {
            // ServerSocket 创建服务器
            ServerSocket server = new ServerSocket(6666);
            boolean run = true;
            while (run) {
                // 阻塞式等待连接
                Socket client = server.accept();
                new Thread(new Service(client)).start();
            }

            server.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static class Service implements Runnable{
        private final Socket client;
        DataInputStream dataInputStream;
        DataOutputStream dataOutputStream;

        Service(Socket client){
            this.client = client;
            try {
                dataInputStream = new DataInputStream(new BufferedInputStream(client.getInputStream()));
                dataOutputStream = new DataOutputStream(new BufferedOutputStream(client.getOutputStream()));
            } catch (Exception e) {
                try {
                    release();
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
                e.printStackTrace();
            }
        }

        @Override
        public void run() {
            try {

                String user = "";
                String password = "";

                // 操作 输入输出流
                String[] dataArray = receive().split("&");

                System.out.println("\n来自 " + client.getInetAddress().getHostName() + ":" + client.getPort() + " 的连接");

                for (String tmp : dataArray) {
                    String[] info = tmp.split("=");
                    switch (info[0]) {
                        case "user":
                            user = info[1];
                        case "password":
                            password = info[1];
                    }
                    System.out.println(info[0] + " => " + info[1]);
                }


                if (user.equals("Shikong") && password.equals("12341234")) {
                    System.out.println(sendCallBack("认证成功"));
                } else {
                    System.out.println(sendCallBack("认证失败"));
                }

                release();
            }catch (Exception e){
                e.printStackTrace();
            }
        }

        // 接收数据
        private String receive() throws IOException {
            return dataInputStream.readUTF();
        }

        // 发送数据
        private void send(String data) throws IOException {
            dataOutputStream.writeUTF(data);
            dataOutputStream.flush();
        }

        private String sendCallBack(String data) throws IOException {
            dataOutputStream.writeUTF(data);
            dataOutputStream.flush();
            return data;
        }

        // 释放资源
        private void release() throws IOException {
            if(dataOutputStream != null)
            {
                dataOutputStream.close();
            }
            if(dataInputStream != null)
            {
                dataInputStream.close();
            }
            if(client != null)
            {
                client.close();
            }
        }
    }
}
