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
 */
public class Server_2 {
    private ServerSocket serverSocket;

    public static void main(String[] args) {
        Server_2 server = new Server_2();
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

            // 返回响应内容
            StringBuilder contentBuilder = new StringBuilder();
            contentBuilder.append("<html>");
            contentBuilder.append("    <head>");
            contentBuilder.append("        <meta charset='utf-8'>");
            contentBuilder.append("        <title> Sk Web Server </title>");
            contentBuilder.append("    </head>");
            contentBuilder.append("    <body>");
            contentBuilder.append("        <h3> Hello World </h3>");
            contentBuilder.append("        <h5> 时空 Web 服务器 </h5>");
            contentBuilder.append("    </body>");
            contentBuilder.append("</html>");

            // 返回响应协议
            StringBuilder responseBuilder = new StringBuilder();
            String BLANK = " ";
            String CRLF = "\r\n";
            String SERVER_VERSION = "Sk Web Server/0.0.1 beta";
            responseBuilder.append("HTTP/1.1").append(BLANK).append(200).append(BLANK).append("OK").append(CRLF);
            responseBuilder.append("Date:").append(new Date()).append(CRLF);
            responseBuilder.append("Server:").append(SERVER_VERSION).append(";").append("charset=utf-8").append(CRLF);
            responseBuilder.append("Content-Type:text/html").append(CRLF);
            responseBuilder.append("Content-Length:").append(contentBuilder.toString().getBytes(StandardCharsets.UTF_8).length).append(CRLF);
            responseBuilder.append(CRLF);
            responseBuilder.append(contentBuilder);

            BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(client.getOutputStream());
            bufferedOutputStream.write(responseBuilder.toString().getBytes(StandardCharsets.UTF_8));
            bufferedOutputStream.flush();

        } catch (IOException e) {
            System.out.println("客户端连接失败");
        }
    }

    // 停止服务
    public void stop() {
    }
}
