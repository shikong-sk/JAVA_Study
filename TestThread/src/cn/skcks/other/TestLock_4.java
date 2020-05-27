package cn.skcks.other;

import java.util.concurrent.locks.ReentrantLock;

/*
    ReentrantLock

    可重入锁 + 锁计数器

    锁可以延续使用
 */
public class TestLock_4 {
    ReentrantLock reLock = new ReentrantLock();

    public void work(){
        System.out.println("锁计数器：" + reLock.getHoldCount());

        // 加锁
        reLock.lock();

        System.out.println("锁计数器：" + reLock.getHoldCount());
        doSomething();
        System.out.println("锁计数器：" + reLock.getHoldCount());

        // 解锁
        reLock.unlock();

        System.out.println("锁计数器：" + reLock.getHoldCount());
    }


    public void doSomething(){
        reLock.lock();
        System.out.println("锁计数器：" + reLock.getHoldCount());
        reLock.unlock();
    }


    public static void main(String[] args) {

        new TestLock_4().work();
    }

}
