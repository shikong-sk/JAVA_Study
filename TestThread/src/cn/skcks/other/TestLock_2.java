package cn.skcks.other;

/*
    不可重入锁

    锁不可以延续使用
 */
public class TestLock_2 {
    Lock lock = new Lock();

    public void work(){
        lock.lock();
        doSomething();
        lock.unlock();
    }

    // 不可重入
    public void doSomething(){
        lock.lock();
        lock.unlock();
    }


    public static void main(String[] args) {
        // 不可重入锁 , 锁未释放无法继续进行 进入死循环
        new TestLock_2().work();
    }

    // 不可重入锁
    static class Lock{
        private boolean isLocked = false;

        public synchronized void lock(){
            while (isLocked)
            {
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            this.isLocked = true;
        }

        public synchronized void unlock(){
            this.isLocked = false;
            notify();
        }
    }
}
