package cn.skcks.other;

/*
    ThreadLocal 每个线程自身的存储区域

    InheritableThreadLocal 继承上下文环境中的数据

    get、set、initialValue
 */
public class TestInheritableThreadLocal {

    // JDK 8 以后版本可用
    // lambda 语法
    private static ThreadLocal<Integer> threadLocal = new InheritableThreadLocal<>();

    public static void main(String[] args) {

        System.out.println(Thread.currentThread().getName() + " => " + threadLocal.get());

        threadLocal.set(100);

        System.out.println(Thread.currentThread().getName() + " => " + threadLocal.get());

        MyRunnable myRunnable = new MyRunnable();
        for (int i = 0; i < 5; i++) {
//            threadLocal.set(100-i);

            // 子线程 由 main 开辟,会继承 main 中的数据
            new Thread(myRunnable).start();
        }
    }

    public static class MyRunnable implements Runnable {

        public MyRunnable() {
            // 在 new 对象时 Thread.currentThread() 为 调用构造器的线程
            // 在此处修改 threadLocal 的值为 调用构造器的线程 中的 threadLocal
            System.out.println(Thread.currentThread().getName() + " => " + threadLocal.get());
        }

        @Override
        public void run() {
            Thread.yield();
            System.out.println(Thread.currentThread().getName() + " => " + threadLocal.get());
        }
    }
}
