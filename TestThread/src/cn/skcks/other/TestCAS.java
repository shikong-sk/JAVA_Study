package cn.skcks.other;

import java.util.concurrent.atomic.AtomicInteger;

/*
    CAS

    比较并交换
 */
public class TestCAS {
    private static final AtomicInteger stock = new AtomicInteger(5);

    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            new Thread(()->{
                // 模拟网络延时
                try {
                    Thread.sleep((int)(Math.random() * (100-10) + 10));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                int num = stock.decrementAndGet();
                if(num < 1)
                {
                    System.out.println(Thread.currentThread().getName() + " => 未抢到 \t\t 已售空");
                    return;
                }

                System.out.println(Thread.currentThread().getName() +" => 抢到了一件 \t 剩余：" + num);
            }).start();
        }
    }
}
