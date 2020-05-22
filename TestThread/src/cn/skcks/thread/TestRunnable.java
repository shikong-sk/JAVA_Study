package cn.skcks.thread;

/*
    Thread 多线程 推荐使用

    通过实现 Runnable 接口 实现
    没有返回值 不能 throw 异常
    避免单继承的局限性,优先使用接口
    方便共享资源
    实现并发

    run() 方法 线程入口
    调用 new Thread().start() 方法 启动线程
 */
public class TestRunnable implements Runnable{

    @Override
    // 线程入口
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println("执行线程");
        }
    }

    public static void main(String[] args) {
        // 分步
//        // 实现类对象
//        TestRunnable testRunnable = new TestRunnable();
//        // 代理类对象
//        Thread thread = new Thread(testRunnable);
//        // 启动线程
//        thread.start();

        // 合并 匿名方式
        new Thread(new TestRunnable()).start();

        for (int i = 0; i < 5; i++) {
            System.out.println("执行 main");
        }
    }
}
