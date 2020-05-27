package cn.skcks.other;

/*
    可重入锁

    锁可以延续使用
 */
public class TestLock {
    public void test(){
        synchronized (this)
        {
            while (true)
            {
                synchronized (this)
                {
                    System.out.println("可重入锁");
                }
                try {
                    Thread.sleep(200);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        }
    }

    public static void main(String[] args) {
        new TestLock().test();
    }
}
