package cn.skcks.thread;

/*
    Thread 多线程

    通过继承 Thread 实现

    run() 方法 线程入口
    调用 start() 方法 启动线程
 */
public class TestThread extends Thread{

    @Override
    // 线程入口
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println("执行线程");
        }
    }

    public static void main(String[] args) {
        // 创建线程对象
        TestThread testThread = new TestThread();
        // 启动线程
        testThread.start(); // 不保证立刻运行，由 CPU 调用

        for (int i = 0; i < 5; i++) {
            System.out.println("执行 main");
        }
    }
}
