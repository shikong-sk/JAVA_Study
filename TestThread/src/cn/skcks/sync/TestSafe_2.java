package cn.skcks.sync;

import java.util.Random;

/*
    线程安全

    并发时保证数据的准确性、一致性
    效率尽可能高,性能略有下降

    synchronized
    1.同步方法 锁定 this 对象
    2.同步块   锁定 指定 对象，目标更明确
 */
public class TestSafe_2 implements Runnable {
    final Cinema cinema;

    public TestSafe_2(Cinema cinema) {
        this.cinema = cinema;
    }

    @Override
    // 线程入口
    public void run() {
        // synchronized 线程同步块
        // 锁定指定对象

        // 提升性能
        if (cinema.ticket <= 0) {
            return;
        }

        synchronized (cinema) {
            if (cinema.ticket <= 0) {
                return;
            }
            while (cinema.ticket > 0) {
                test();
            }
        }
    }

    public void test() {

        try {
            Thread.sleep(0);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        int buy = (int)(Math.random() * (10-5)+5);
        int ticket = cinema.ticket;
        int remaining = cinema.Buy(buy);
        System.out.println(Thread.currentThread().getName() + " => " + buy + " 实际购买：" + ((ticket-buy)>0?buy:ticket) + " 剩余：" + remaining);


    }

    public static void main(String[] args) {
        Cinema cinema = new Cinema(100);

        TestSafe_2 testSafe = new TestSafe_2(cinema);

        // 获取当前线程名称
        System.out.println(Thread.currentThread().getName());

        // 多个进程共享一个资源
        new Thread(testSafe, "时空").start();
        new Thread(testSafe, "时间").start();
        new Thread(testSafe, "时光").start();

    }

    static class Cinema {
        int ticket;

        public Cinema(int ticket) {
            this.ticket = ticket;
        }

        public int Buy() {
            return this.ticket--;
        }

        public int Buy(int num) {
            if(this.ticket - num > 0)
            {
                return this.ticket -= num;
            }
            return this.ticket = 0;
        }
    }

}
