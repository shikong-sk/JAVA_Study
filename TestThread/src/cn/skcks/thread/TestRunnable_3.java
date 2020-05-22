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
public class TestRunnable_3 implements Runnable{

    private String winner;

    private final static int end = 15;

    @Override
    // 线程入口
    public void run() {

        for (int step = 1; step <= end; step++) {

            if(winner != null)
            {
                break;
            }
            else if(step == end)
            {
                System.out.println(Thread.currentThread().getName() + " => " + step);

                winner = Thread.currentThread().getName();
                System.out.println("胜利者：" + winner);
            }
            else{
                System.out.println(Thread.currentThread().getName() + " => " + step);
                if(Thread.currentThread().getName().equals("时空") && step%10 == 0)
                {
                    try {
                        Thread.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        TestRunnable_3 testRunnable_3 = new TestRunnable_3();

        // 获取当前线程名称
        System.out.println(Thread.currentThread().getName());

        // 多个进程共享一个资源
        new Thread(testRunnable_3,"时空").start();
        new Thread(testRunnable_3,"时间").start();

    }
}
