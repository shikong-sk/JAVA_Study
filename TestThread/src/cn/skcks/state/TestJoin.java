package cn.skcks.state;

import java.text.SimpleDateFormat;
import java.util.Date;

/*
    join 合并线程 插队线程

    阻塞其他线程的运行
 */
public class TestJoin {

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(()->{
            for (int i = 0; i < 10; i++) {
                System.out.println("lambda => " + i);
            }
        });
        thread.start();

        for (int i = 0; i < 20; i++) {
            if (i == 10)
            {
                // thread 线程插队
                // 阻塞 main 线程
                thread.join();
            }
            System.out.println("main => " + i);
        }
    }
}
