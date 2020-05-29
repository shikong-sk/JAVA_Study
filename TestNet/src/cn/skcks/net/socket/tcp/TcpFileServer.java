package cn.skcks.net.socket.tcp;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/*
    TCP FileServer

    存储文件
    使用 ServerSocket 创建服务器
    阻塞式等待连接 accept
    输入输出流操作
    释放资源
 */
public class TcpFileServer {
    public static void main(String[] args) {
        try {
            // ServerSocket 创建服务器
            ServerSocket server = new ServerSocket(6666);
            // 阻塞式等待连接
            Socket client = server.accept();

            System.out.println("连接已建立");

            // 操作 输入输出流
            InputStream inputStream = new BufferedInputStream(client.getInputStream());
            OutputStream outputStream = new BufferedOutputStream(new FileOutputStream("io/dest_tcp.png"));

            byte[] flush = new byte[1024];  // 1024B = 1K
            int len;
            while ((len = inputStream.read(flush)) != -1)
            {
                outputStream.write(flush,0,len);
            }
            outputStream.flush();

            outputStream.close();
            inputStream.close();
            client.close();
            server.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
