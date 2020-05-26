package cn.skcks.state;

import java.text.SimpleDateFormat;
import java.util.Date;

/*
    Sleep 模拟倒计时
 */
public class TestSleep_1{

    public static void main(String[] args) throws InterruptedException {
        Date eDate = new Date(System.currentTimeMillis() + 1000 * 5);
        long endTime = eDate.getTime();
        while(true)
        {
            System.out.println(new SimpleDateFormat("hh:mm:ss").format(eDate));
            Thread.sleep(1000);
            eDate = new Date(eDate.getTime() - 1000);
            if(System.currentTimeMillis() >= endTime){
                break;
            }
        }

    }

    public static void test() throws InterruptedException {
        int time = 3;
        while (time >= 0){
            Thread.sleep(1000);
            System.out.println(time--);
        }
    }

}
