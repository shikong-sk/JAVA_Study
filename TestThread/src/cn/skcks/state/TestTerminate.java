package cn.skcks.state;

/*
    终止线程运行

    线程正常执行完毕
    外部干涉 加入标识

    不要使用 stop 或 destroy 方法
 */
public class TestTerminate implements Runnable {

    private boolean flag = true;

    @Override
    public void run() {
        int i = 0;
        while (flag) {
            i++;
        }
        System.out.println("执行了：" + i + "次");
    }

    public void terminate() {
        this.flag = false;
    }

    public static void main(String[] args) {
        TestTerminate testTerminate = new TestTerminate();

        new Thread(testTerminate).start();

        int time = 100;
        for (int i = 0; i <= time; i++) {
            if(i == time * 0.8) {
                testTerminate.terminate();
                System.out.println("线程 运行结束");
            }
            System.out.println("主线程 main");
        }
    }
}
