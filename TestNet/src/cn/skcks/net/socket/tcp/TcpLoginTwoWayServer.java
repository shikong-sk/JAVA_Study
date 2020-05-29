package cn.skcks.net.socket.tcp;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/*
    TCP LoginTwoWayServer 双向

    使用 ServerSocket 创建服务器
    阻塞式等待连接 accept
    输入输出流操作
    释放资源
 */
public class TcpLoginTwoWayServer {
    public static void main(String[] args) {
        try {
            // ServerSocket 创建服务器
            ServerSocket server = new ServerSocket(6666);
            // 阻塞式等待连接
            Socket client = server.accept();

            System.out.println("连接已建立");

            String user = "";
            String password = "";

            // 操作 输入输出流
            DataInputStream dataInputStream = new DataInputStream(new BufferedInputStream(client.getInputStream()));

            String data = dataInputStream.readUTF();

            String[] dataArray = data.split("&");
            for(String tmp:dataArray)
            {
                String[] info = tmp.split("=");
                switch (info[0])
                {
                    case "user":user = info[1];
                    case "password":password = info[1];
                }
                System.out.println(info[0] + " => " + info[1]);
            }

            DataOutputStream dataOutputStream = new DataOutputStream(new BufferedOutputStream(client.getOutputStream()));
            if(user.equals("Shikong") && password.equals("12341234"))
            {

                dataOutputStream.writeUTF("认证成功");
            }
            else{
                dataOutputStream.writeUTF("认证失败");
            }

            dataOutputStream.flush();
            dataOutputStream.close();
            dataInputStream.close();
            client.close();
            server.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
