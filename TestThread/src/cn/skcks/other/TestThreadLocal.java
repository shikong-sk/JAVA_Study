package cn.skcks.other;

/*
    ThreadLocal 每个线程自身的存储区域

    get、set、initialValue
 */
public class TestThreadLocal {
//    private static ThreadLocal<Integer> threadLocal = new ThreadLocal<>();

    // 初始化
//    private static ThreadLocal<Integer> threadLocal = new ThreadLocal<Integer>(){
//        protected Integer initialValue(){
//          return 100;
//        }
//    };

    // JDK 8 以后版本可用
    // lambda 语法
    private static ThreadLocal<Integer> threadLocal = ThreadLocal.withInitial(() -> (int) (Math.random() * (5 - 1)) + 1);

    public static void main(String[] args) {

        System.out.println(Thread.currentThread().getName() + " => " + threadLocal.get());
        threadLocal.set(threadLocal.get() - 1);
        System.out.println(Thread.currentThread().getName() + " => " + threadLocal.get());

        MyRunnable myRunnable = new MyRunnable();
        for (int i = 0; i < 5; i++) {
            new Thread(myRunnable).start();
        }
    }

    public static class MyRunnable implements Runnable {

        public MyRunnable(){
            // 在 new 对象时 Thread.currentThread() 为 调用构造器的线程
            // 在此处修改 threadLocal 的值为 调用构造器的线程 中的 threadLocal
            threadLocal.set(100);
            System.out.println(Thread.currentThread().getName() + " => " + threadLocal.get());
        }

        @Override
        public void run() {
            Thread.yield();
            System.out.println(Thread.currentThread().getName() + " => " + threadLocal.get());
        }
    }
}
