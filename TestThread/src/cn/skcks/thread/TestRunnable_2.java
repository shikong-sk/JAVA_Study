package cn.skcks.thread;

/*
    Thread 多线程 推荐使用

    通过实现 Runnable 接口 实现
    避免单继承的局限性,优先使用接口
    方便共享资源
    实现并发

    run() 方法 线程入口
    调用 new Thread().start() 方法 启动线程
 */
public class TestRunnable_2 implements Runnable{

    private int num = 5;

    @Override
    // 线程入口
    public void run() {
        while (num >= 0) {
//            try {
//                Thread.sleep(100);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
            System.out.println(Thread.currentThread().getName() + " => " + num--);
        }
    }

    public static void main(String[] args) {
        TestRunnable_2 testRunnable_2 = new TestRunnable_2();

        // 获取当前线程名称
        System.out.println(Thread.currentThread().getName());

        // 多个进程共享一个资源
        new Thread(testRunnable_2,"时空").start();
        new Thread(testRunnable_2,"时间").start();
        new Thread(testRunnable_2,"时光").start();

    }
}
