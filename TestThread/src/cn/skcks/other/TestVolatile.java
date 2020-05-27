package cn.skcks.other;

/*
    Volatile

    用于保证数据的同步
    即数据的可见性
 */
public class TestVolatile {
    private volatile static int num = 0;

    public static void main(String[] args) {
        new Thread(()->{
            while (num == 0){}
        }).start();

        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        num = 1;
    }
}
