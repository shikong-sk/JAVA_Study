package cn.skcks.other;

import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.*;

/*
    Timer 计时器
 */
public class TestTimer {
    public static void main(String[] args) {
        Timer timer = new Timer();
//        timer.schedule(new Task(),500);     // 只执行一次
//        timer.schedule(new Task(),500,1000);     // 每 1000ms 执行一次
        
        //  到达指定时间后,每 1000ms 执行一次
        timer.schedule(new Task(), new GregorianCalendar(2020, Calendar.MAY, 27, 2, 59, 30).getTime(), 1000);
    }

    static class Task extends TimerTask {
        @Override
        public void run() {
            for (int i = 0; i < 10; i++) {
                System.out.println("等待");
            }
            System.out.println("========= 结束 =========");
        }
    }
}
