package cn.skcks.state;

/*
    State 状态观察

    NEW             新生状态

    RUNNABLE        运行中

    TIMED_WAITING   时间等待    等待阻塞

    TERMINATED      线程结束
 */
public class TestState {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("活动的线程：" + Thread.activeCount());

        Thread thread = new Thread(()->{
            System.out.println("线程运行中");
            for (int i = 0; i < 100; i++) {
                if (i == 80)
                {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });

        Thread.State state = thread.getState();
        System.out.println(state);

        thread.start();
        state = thread.getState();
        System.out.println(state);

        System.out.println("活动的线程：" + Thread.activeCount());

        Thread.sleep(800);
        state = thread.getState();
        System.out.println(state);

        Thread.sleep(250);
        state = thread.getState();
        System.out.println(state);
        System.out.println("活动的线程：" + Thread.activeCount());
    }
}
