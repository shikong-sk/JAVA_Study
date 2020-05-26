package cn.skcks.sync;

/*
    线程安全

    并发时保证数据的准确性、一致性
    效率尽可能高,性能略有下降

    synchronized
    1.同步方法
    2.同步块
 */
public class TestSafe implements Runnable{
    private int num = 500;
    private boolean flag = true;

    @Override
    // 线程入口
    public void run() {
        while (flag) {
            test();
        }
        flag = true;
    }

    // 线程安全 同步标志
    // 锁定 this 对象
    public synchronized void test(){
        if(num < 0)
        {
            flag = false;
            return;
        }
        try {
            Thread.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + " => " + num--);
    }

    public static void main(String[] args) {
        TestSafe testUnsafe = new TestSafe();

        // 获取当前线程名称
        System.out.println(Thread.currentThread().getName());

        // 多个进程共享一个资源
        new Thread(testUnsafe,"时空").start();
        new Thread(testUnsafe,"时间").start();
        new Thread(testUnsafe,"时光").start();
    }
}
