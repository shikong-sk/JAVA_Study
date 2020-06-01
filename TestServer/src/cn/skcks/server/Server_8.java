package cn.skcks.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Arrays;

/*
    使用 ServerSocket 建立 web 服务器 与浏览器连接，获取请求协议

    返回响应协议
    封装响应信息
        动态添加内容
        状态码、拼接响应信息
    返回请求参数
    加入 Servlet 解耦业务代码
    整合配置文件
    加入多线程分发器
 */
public class Server_8 {
    private ServerSocket serverSocket;
    private boolean run;

    public static void main(String[] args) {
        Server_8 server = new Server_8();
        server.start();
    }

    // 启动服务
    public void start() {
        try {
            serverSocket = new ServerSocket(8848);
            run = true;
            receive();
        } catch (IOException e) {
            System.out.println("服务器启动失败,请检查端口是否被占用");
            stop();
        }
    }

    // 接收数据
    public void receive() {
        try {
            while (run)
            {
                Socket client = serverSocket.accept();
                System.out.println(client.getInetAddress().getHostAddress() + ":" + client.getPort() + " 已连接");

                new Thread(new Dispatcher(client)).start();
            }
        } catch (IOException e) {
            System.out.println("客户端连接失败");
            stop();
        }
    }

    // 停止服务
    public void stop() {
        run = false;
        try {
            this.serverSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
