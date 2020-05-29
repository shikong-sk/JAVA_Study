package cn.skcks.net.socket.tcp;

import java.io.*;
import java.net.Socket;

/*
    TCP FileClient

    上传文件
    使用 Socket 创建客户端 、 建立连接 需指定 服务器地址和端口
    输入输出流操作
    释放资源
 */
public class TcpFileClient {
    public static void main(String[] args) {
        try {
            Socket client = new Socket("localhost",6666);

            InputStream inputStream = new BufferedInputStream(new FileInputStream("io/src.png"));
            OutputStream outputStream = new BufferedOutputStream(client.getOutputStream());

            byte[] flush = new byte[1024];  // 1024B = 1K
            int len;
            while ((len = inputStream.read(flush)) != -1)
            {
                outputStream.write(flush,0,len);
            }
            outputStream.flush();

            outputStream.close();

            System.out.println("文件上传完成");

            inputStream.close();
            client.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
