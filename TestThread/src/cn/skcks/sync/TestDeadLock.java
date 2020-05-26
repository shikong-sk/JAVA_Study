package cn.skcks.sync;

/*
    死锁：过多的同步导致互相占用不释放资源
    从而互相等待，一般发生于同步中持有多个对象的锁

    避免在同一个代码块中持有多个锁

 */
public class TestDeadLock {

    static class Eat implements Runnable {
        static final Knife knife = new Knife();
        static final Fork fork = new Fork();

        int choose;

        public Eat(int choose) {
            this.choose = choose;
        }

        @Override
        public void run() {
            try {
                if (choose == 0) {
                    synchronized (knife) {
                        System.out.println(Thread.currentThread().getName() + "拿到了刀");
                        Thread.sleep(100);
                    }
                    synchronized (fork) {
                        System.out.println(Thread.currentThread().getName() + "拿到了叉子");
                    }
                } else {
                    synchronized (fork) {
                        System.out.println(Thread.currentThread().getName() + "拿到了叉子");
                        Thread.sleep(200);
                    }
                    synchronized (knife) {
                        System.out.println(Thread.currentThread().getName() + "拿到了刀");
                    }
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        private void DeadLock(){
            // 模拟并发死锁
            // 互相持有另一个对象的锁
            try {
                if (choose == 0) {
                    synchronized (knife) {
                        System.out.println(Thread.currentThread().getName() + "拿到了刀");
                        Thread.sleep(100);
                        synchronized (fork) {
                            System.out.println(Thread.currentThread().getName() + "拿到了叉子");
                        }
                    }
                } else {
                    synchronized (fork) {
                        System.out.println(Thread.currentThread().getName() + "拿到了叉子");
                        Thread.sleep(200);
                        synchronized (knife) {
                            System.out.println(Thread.currentThread().getName() + "拿到了刀");
                        }
                    }
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread a = new Thread(new Eat(1),"时空");
        a.start();
        Thread b = new Thread(new Eat(0),"熊猫");
        b.start();

        Thread.sleep(2000);

        if(a.isAlive() && b.isAlive())
        {
            System.out.println("检测到并发死锁");
            System.out.println("===========================");
            a.interrupt();
            a.stop();
            b.interrupt();
            b.stop();
            System.out.println("强制结束线程");
            System.exit(0);
        }
    }

    static class Knife {
    }

    static class Fork {
    }
}

