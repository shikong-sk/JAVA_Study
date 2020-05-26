package cn.skcks.state;

/*
    Priority
    线程优先级 1-10

    默认优先级 5

    NORM_PRIORITY 5
    MIN_PRIORITY 1
    MAX_PRIORITY 10

    仅为概率，不代表绝对顺序
 */
public class TestPriority {
    static class thread implements Runnable{
        @Override
        public void run() {
            System.out.println("线程 " + Thread.currentThread().getName() + " , 优先级：" + Thread.currentThread().getPriority());
        }
    }

    public static void main(String[] args){
        thread thread = new thread();

        Thread thread1 = new Thread(thread);
        thread1.setPriority(1);
        thread1.start();

        Thread thread2 = new Thread(thread);
        thread2.setPriority(3);
        thread2.start();

        Thread thread3 = new Thread(thread);
        thread3.setPriority(5);
        thread3.start();

        Thread thread4 = new Thread(thread);
        thread4.setPriority(7);
        thread4.start();

        Thread thread5 = new Thread(thread);
        thread5.setPriority(9);
        thread5.start();

        System.out.println("main 线程优先级：" + Thread.currentThread().getPriority());
    }
}
