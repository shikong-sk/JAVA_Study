package cn.skcks.server;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

/*
    使用 ServerSocket 建立 web 服务器 与浏览器连接，获取请求协议
 */
public class Server {
    private ServerSocket serverSocket;

    public static void main(String[] args) {
        Server server = new Server();
        server.start();
    }

    // 启动服务
    public void start() {
        try {
            serverSocket = new ServerSocket(8848);
            receive();
        } catch (IOException e) {
            System.out.println("服务器启动失败,请检查端口是否被占用");
        }
    }

    // 接收数据
    public void receive() {
        try {
            Socket client = serverSocket.accept();
            System.out.println(client.getInetAddress().getHostAddress() + ":" + client.getPort() + " 已连接");

            // 获取请求协议
            InputStream inputStream = new BufferedInputStream(client.getInputStream());

            byte[] flush = new byte[1024];
            int len;
            while ((len = inputStream.read(flush)) != -1) {
                System.out.print(new String(flush, 0, len));
            }


        } catch (IOException e) {
            System.out.println("客户端连接失败");
        }
    }

    // 停止服务
    public void stop() {
    }
}
