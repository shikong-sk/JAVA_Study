package cn.skcks.thread;

/*
    Thread + Lambda

    简化线程的使用
 */
public class TestLambda_5 {

    public static void main(String[] args) {
        // JDK8 简化 lambda表达式
        new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                System.out.println("执行线程1");
            }
        }).start();

        // 单行代码简化
        new Thread(() -> System.out.println("执行线程2")).start();

    }
}

