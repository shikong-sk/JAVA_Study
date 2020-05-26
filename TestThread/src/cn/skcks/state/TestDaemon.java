package cn.skcks.state;

/*
    Daemon 守护线程

    线程默认为用户线程
    jvm 等待所有用户线程结束后才关闭
 */
public class TestDaemon {
    public static void main(String[] args) {
        God god = new God();
        My my = new My();
        Thread t = new Thread(god);
        t.setDaemon(true);
        t.start();

        new Thread(my).start();
    }

    static class My implements Runnable{
        @Override
        public void run() {
            for(int i=0;i<365*100;i++)
            {
                System.out.println("生存：" + (i+1) + "天");
            }
        }
    }

    static class God implements Runnable{
        @Override
        public void run() {
            for (int i = 0; i < 365*1000; i++) {
                System.out.println("创世：" + (i+1) + "天");
            }
        }
    }
}
