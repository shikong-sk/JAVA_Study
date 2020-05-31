package cn.skcks.server;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.Date;

/*
    使用 ServerSocket 建立 web 服务器 与浏览器连接，获取请求协议

    返回响应协议
    封装响应信息
        动态添加内容
        状态码、拼接响应信息
 */
public class Server_3 {
    private ServerSocket serverSocket;

    public static void main(String[] args) {
        Server_3 server = new Server_3();
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

            StringBuilder stringBuilder = new StringBuilder();
            byte[] flush = new byte[1024];
            int len;
            while ((len = inputStream.read(flush)) != -1) {
                stringBuilder.append(new String(flush, 0, len));

                if(len < flush.length)break;
            }
            String request = stringBuilder.toString();
            System.out.println(request);

            // 写入响应内容
            Response response = new Response(client);
            response.addContentWithCRLF("<html>");
            response.addContentWithCRLF("    <head>");
            response.addContentWithCRLF("        <meta charset='utf-8'>");
            response.addContentWithCRLF("        <title> Sk Web Server </title>");
            response.addContentWithCRLF("    </head>");
            response.addContentWithCRLF("    <body>");
            response.addContentWithCRLF("        <h3> Hello World </h3>");
            response.addContentWithCRLF("        <h5> 时空 Web 服务器 </h5>");
            response.addContentWithCRLF("    </body>");
            response.addContentWithCRLF("</html>");
            // 指定状态码 返回响应请求
            response.response(200);

        } catch (IOException e) {
            System.out.println("客户端连接失败");
        }
    }

    // 停止服务
    public void stop() {
    }
}
