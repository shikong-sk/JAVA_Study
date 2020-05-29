package cn.skcks.net.socket.tcp;

import java.io.BufferedOutputStream;
import java.io.DataOutputStream;
import java.net.Socket;

/*
    TCP Client

    使用 Socket 创建客户端 、 建立连接 需指定 服务器地址和端口
    输入输出流操作
    释放资源
 */
public class TcpClient {
    public static void main(String[] args) {
        try {
            Socket client = new Socket("localhost",6666);

            DataOutputStream dataOutputStream = new DataOutputStream(new BufferedOutputStream(client.getOutputStream()));

            dataOutputStream.writeUTF("Hello world!");
            dataOutputStream.flush();
            dataOutputStream.close();
            client.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
