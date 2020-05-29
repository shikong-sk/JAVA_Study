package cn.skcks.net.socket.tcp;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Arrays;

/*
    TCP LoginServer 单向

    使用 ServerSocket 创建服务器
    阻塞式等待连接 accept
    输入输出流操作
    释放资源
 */
public class TcpLoginServer {
    public static void main(String[] args) {
        try {
            // ServerSocket 创建服务器
            ServerSocket server = new ServerSocket(6666);
            // 阻塞式等待连接
            Socket client = server.accept();

            System.out.println("连接已建立");
            // 操作 输入输出流
            DataInputStream dataInputStream = new DataInputStream(new BufferedInputStream(client.getInputStream()));

            String data = dataInputStream.readUTF();

            String[] dataArray = data.split("&");
            for(String tmp:dataArray)
            {
                String[] t = tmp.split("=");
                System.out.println(t[0] + " => " + t[1]);
            }

            dataInputStream.close();
            client.close();
            server.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
