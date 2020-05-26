package cn.skcks.sync;

/*
    线程安全

    并发时保证数据的准确性、一致性
    效率尽可能高,性能略有下降

    synchronized
    1.同步方法 锁定 this 对象
    2.同步块   锁定 指定 对象，目标更明确
 */
public class TestSafe_3 implements Runnable {
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
    // 尽可能锁定合理范围，确保数据的完整性
    // 双重检测
    public void test() {
        if (num < 0) {      // 没有票时，直接返回
            flag = false;
            return;
        }
        synchronized (this) {
            if (num < 0) {      // 最后一张票的抢夺
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
    }

    public void test1() {
        // num 对象一直在变化，无法锁定
        synchronized ((Integer) num) {
            if (num < 0) {
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

    }

    public void test2() {
        // 锁定范围过小,锁定失败
        synchronized (this) {
            if (num < 0) {
                flag = false;
                return;
            }
        }
        try {
            Thread.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + " => " + num--);

    }

    public void test3() {
        // 锁定范围大，效率低
        synchronized (this) {
            if (num < 0) {
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
    }

    public static void main(String[] args) {
        TestSafe_3 testUnsafe = new TestSafe_3();

        // 获取当前线程名称
        System.out.println(Thread.currentThread().getName());

        // 多个进程共享一个资源
        new Thread(testUnsafe, "时空").start();
        new Thread(testUnsafe, "时间").start();
        new Thread(testUnsafe, "时光").start();

    }
}
