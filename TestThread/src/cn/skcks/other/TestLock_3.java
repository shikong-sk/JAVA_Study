package cn.skcks.other;

/*
    可重入锁 + 锁计数器

    锁可以延续使用
 */
public class TestLock_3 {
    ReLock reLock = new ReLock();

    public void work(){
        System.out.println("锁计数器：" + reLock.getLockNum());

        // 加锁
        reLock.lock();

        System.out.println("锁计数器：" + reLock.getLockNum());
        doSomething();
        System.out.println("锁计数器：" + reLock.getLockNum());

        // 解锁
        reLock.unlock();

        System.out.println("锁计数器：" + reLock.getLockNum());
    }


    public void doSomething(){
        reLock.lock();
        System.out.println("锁计数器：" + reLock.getLockNum());
        reLock.unlock();
    }


    public static void main(String[] args) {

        new TestLock_3().work();
    }

    // 可重入锁
    static class ReLock {
        private boolean isLocked = false;
        private Thread lockedBy = null; // 存储线程
        private int lockNum = 0;

        public synchronized void lock(){
            Thread thread = Thread.currentThread();
            while (isLocked && lockedBy != thread)
            {
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            this.isLocked = true;
            lockedBy = thread;
            lockNum++;
        }

        public synchronized void unlock(){
            if (lockedBy == Thread.currentThread())
            {
                lockNum--;
                if(lockNum == 0)
                {
                    this.isLocked = false;
                    notify();
                    lockedBy = null;
                }
            }
        }

        public int getLockNum() {
            return lockNum;
        }
    }
}
