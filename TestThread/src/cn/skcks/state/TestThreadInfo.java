package cn.skcks.state;

/*
    Thread 其他方法

    isAlive 线程存活状态
    Thread.currentThread() 当前线程
    setName 设置线程名称
    getName 获取线程名称
 */
public class TestThreadInfo {
    static class ThreadInfo implements Runnable{
        @Override
        public void run() {
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread t = new Thread(new ThreadInfo());
        t.setName("线程 X");
        t.start();

        System.out.println(t.getName() + " : " + t.isAlive());

        Thread.sleep(800);

        System.out.println(t.getName() + " : " + t.isAlive());
    }
}
