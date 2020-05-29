package cn.skcks.net.socket.tcp;

import javax.xml.crypto.Data;
import java.io.*;
import java.net.Socket;

/*
    TCP MultiLoginTwoWayClient 多用户双向

    使用 Socket 创建客户端 、 建立连接 需指定 服务器地址和端口
    输入输出流操作
    释放资源
 */
public class TcpMultiLoginTwoWayClient {
    public static void main(String[] args) {
        try {




            Socket client = new Socket("localhost",6666);

            Send send = new Send(client);
            Receive receive = new Receive(client);

            receive.receive();


            send.release();
            receive.release();

            client.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static class Send{
        Socket client;
        private DataOutputStream dataOutputStream;
        BufferedReader bufferedReader;

        public Send(Socket client) {
            try {
                bufferedReader =  new BufferedReader(new InputStreamReader(System.in));
                this.client = client;
                this.dataOutputStream = new DataOutputStream(new BufferedOutputStream(client.getOutputStream()));

                init();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        public void init(){
            try {
                System.out.print("用户名：");
                String user = bufferedReader.readLine();
                System.out.print("密码：");
                String password = bufferedReader.readLine();
                login(user,password);
            } catch (IOException e) {
                e.printStackTrace();
            }

        }

        public void login(String user,String password)
        {
            try {
                dataOutputStream.writeUTF("user=" + user + "&" + "password=" + password);
                dataOutputStream.flush();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        public void release(){
            if(dataOutputStream != null)
            {
                try {
                    dataOutputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    static class Receive{
        Socket client;
        private DataInputStream dataInputStream;

        public Receive(Socket client) {
            try {
                this.client = client;
                dataInputStream = new DataInputStream(new BufferedInputStream(client.getInputStream()));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        public void receive(){
            String data = null;
            try {
                data = dataInputStream.readUTF();
                System.out.println(data);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        public void release(){
            if(dataInputStream != null)
            {
                try {
                    dataInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }


}
