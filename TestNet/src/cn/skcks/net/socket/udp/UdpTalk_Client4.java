package cn.skcks.net.socket.udp;

/*
    Udp 通讯

    加入多线程
    双向交流
 */
public class UdpTalk_Client4 {
    public static void main(String[] args) {
        // 发送和监听的端口 目标地址 目标端口
        new Thread(new UdpTalkCore(6666,"localhost",5555)).start();
    }
}
