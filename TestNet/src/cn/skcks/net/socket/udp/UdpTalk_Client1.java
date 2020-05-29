package cn.skcks.net.socket.udp;

/*
    Udp 通讯

    加入多线程
    双向交流
 */
public class UdpTalk_Client1 {
    public static void main(String[] args) {
        // 将信息从 哪个端口 发送至 目标 的 哪个端口
        new Thread(new UdpTalkSend(5555,"localhost",6666)).start();

        // 接收来自哪个端口的信息 , 退出时回复哪个端口
//        new Thread(new UdpTalkReceive(5556)).start();
        new Thread(new UdpTalkReceive(5556)).start();
    }
}
