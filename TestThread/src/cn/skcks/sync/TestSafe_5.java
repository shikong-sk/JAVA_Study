package cn.skcks.sync;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/*
    线程安全

    并发时保证数据的准确性、一致性
    效率尽可能高,性能略有下降

    synchronized
    1.同步方法 锁定 this 对象
    2.同步块   锁定 指定 对象，目标更明确

    CopyOnWriteArrayList
    并发容器,其内部已实现 synchronized
 */
public class TestSafe_5 implements Runnable {
    final Cinema cinema;
    CopyOnWriteArrayList<Integer> buy;

    public TestSafe_5(Cinema cinema, CopyOnWriteArrayList<Integer> buy) {
        this.cinema = cinema;
        this.buy = buy;
    }

    @Override
    // 线程入口
    public void run() {
        // synchronized 线程同步块
        // 锁定指定对象
//        Thread.yield(); // 模拟资源抢夺
//        synchronized (cinema) {
            System.out.println("剩余位置：" + cinema.getTicket().toString());
            test();
//        }

    }

    public void test() {
        try {
            Thread.sleep(0);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(Thread.currentThread().getName() + " => " + this.buy.toString() + " " + (cinema.Buy(this.buy) ? "购票成功" : "购票失败") + " 剩余：" + cinema.ticket.size());

    }

    public static void main(String[] args) {
        Cinema cinema = new Cinema(10);

        CopyOnWriteArrayList<Integer> a = new CopyOnWriteArrayList<>();
        a.add(1);
        a.add(2);
        CopyOnWriteArrayList<Integer> b = new CopyOnWriteArrayList<>();
        b.add(0);
        b.add(1);
        b.add(2);
        CopyOnWriteArrayList<Integer> c = new CopyOnWriteArrayList<>();
        c.add(7);
        c.add(8);
        c.add(9);

        // 多个进程共享一个资源
        Thread A = new Thread(new TestSafe_5(cinema, a), "时空");
        Thread B = new Thread(new TestSafe_5(cinema, b), "时间");
        Thread C = new Thread(new TestSafe_5(cinema, c), "时光");
        A.start();
        B.start();
        C.start();

        while (true){
            if(!A.isAlive() && !B.isAlive() && !C.isAlive())
            {
                System.out.println("剩余位置：" + cinema.getTicket().toString());
                break;
            }
        }

    }

    static class Cinema {
        CopyOnWriteArrayList<Integer> ticket;

        public Cinema(int ticket) {
            this.ticket = new CopyOnWriteArrayList<>();
            for (int i = 0; i < ticket; i++) {
                this.ticket.add(i, i);
            }
        }

        public boolean Buy(CopyOnWriteArrayList<Integer> buy) {
            if(this.ticket.size() == 0)
            {
                return false;
            }
            else if (buy.size() == 0)
            {
                return false;
            }

            CopyOnWriteArrayList<Integer> copy = new CopyOnWriteArrayList<>(ticket);

            copy.removeAll(buy);

            if (ticket.size() - copy.size() == buy.size()) {
                ticket = copy;
                return true;
            }
            return false;
        }

        public List<Integer> getTicket(){
            return this.ticket;
        }

    }

}
