package cn.skcks.state;

import java.text.SimpleDateFormat;
import java.util.Date;

/*
    yield 礼让线程

    暂停线程
    让出 cpu 调度资源
    直接进入就绪状态
 */
public class TestYield {
    static class Yield implements Runnable{
        @Override
        public void run() {
            System.out.println("线程 " + Thread.currentThread().getName() +" 开始：" + new SimpleDateFormat("HH:mm:ss").format(new Date(System.currentTimeMillis())));
            Thread.yield(); // 暂停线程
            System.out.println("线程 "+ Thread.currentThread().getName() +" 结束：" +  new SimpleDateFormat("HH:mm:ss").format(new Date(System.currentTimeMillis())));
        }
    }

    public static void main(String[] args) {
        Yield yield = new Yield();
        new Thread(yield,"A").start();
        new Thread(yield,"B").start();
    }
}
