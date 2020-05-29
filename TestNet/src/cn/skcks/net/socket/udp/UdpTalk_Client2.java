package cn.skcks.net.socket.udp;

/*
    Udp 通讯

    加入多线程
    双向交流
 */
public class UdpTalk_Client2 {
    public static void main(String[] args) {
        new Thread(new UdpTalkSend(6665,"localhost",5556)).start();

        new Thread(new UdpTalkReceive(6666)).start();
    }
}
