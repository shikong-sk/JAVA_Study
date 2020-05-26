package cn.skcks.state;

/*
    Sleep 模拟网络延迟 运行阻塞
 */
public class TestSleep implements Runnable{

    private int num = 5;

    @Override
    // 线程入口
    public void run() {
        while (num >= 0) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + " => " + num--);
        }
    }

    public static void main(String[] args) {
        TestSleep testRunnable_2 = new TestSleep();

        // 获取当前线程名称
        System.out.println(Thread.currentThread().getName());

        // 多个进程共享一个资源
        new Thread(testRunnable_2,"时空").start();
        new Thread(testRunnable_2,"时间").start();
        new Thread(testRunnable_2,"时光").start();

    }
}
