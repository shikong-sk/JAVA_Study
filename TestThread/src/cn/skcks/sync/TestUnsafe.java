package cn.skcks.sync;

/*
    线程不安全

    数据出现 负数 和 重复值
 */
public class TestUnsafe implements Runnable{
    private int num = 5;

    @Override
    // 线程入口
    public void run() {
        while (num >= 0) {
            test();
        }
    }

    public void test(){
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + " => " + num--);
    }

    public static void main(String[] args) {
        TestUnsafe testUnsafe = new TestUnsafe();

        // 获取当前线程名称
        System.out.println(Thread.currentThread().getName());

        // 多个进程共享一个资源
        new Thread(testUnsafe,"时空").start();
        new Thread(testUnsafe,"时间").start();
        new Thread(testUnsafe,"时光").start();

    }
}
