package cn.skcks.net.socket.tcp;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.Socket;

/*
    TCP LoginClient 单向

    使用 Socket 创建客户端 、 建立连接 需指定 服务器地址和端口
    输入输出流操作
    释放资源
 */
public class TcpLoginClient {
    public static void main(String[] args) {
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

            System.out.print("用户名：");
            String user = bufferedReader.readLine();
            System.out.print("密码：");
            String password = bufferedReader.readLine();

            Socket client = new Socket("localhost",6666);

            DataOutputStream dataOutputStream = new DataOutputStream(new BufferedOutputStream(client.getOutputStream()));
            dataOutputStream.writeUTF("user=" + user + "&" + "password=" + password);

            dataOutputStream.flush();
            dataOutputStream.close();
            client.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
