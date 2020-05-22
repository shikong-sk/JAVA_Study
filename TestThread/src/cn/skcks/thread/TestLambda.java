package cn.skcks.thread;

/*
    Lambda 表达式

    简化线程的使用
    避免匿名内部类过多
    函数式编程
 */
public class TestLambda{

    // 静态内部类
    static class Test implements Runnable {
        @Override
        // 线程入口
        public void run() {
            for (int i = 0; i < 5; i++) {
                System.out.println("执行线程");
            }
        }
    }

    public static void main(String[] args) {
//        new Thread(new Test()).start();

        // 局部内部类
//        class Test2 implements Runnable {
//            @Override
//            // 线程入口
//            public void run() {
//                for (int i = 0; i < 5; i++) {
//                    System.out.println("执行线程");
//                }
//            }
//        }

//        new Thread(new Test2()).start();

        // 匿名内部类 必须借助接口类 或 父类
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                for (int i = 0; i < 5; i++) {
//                    System.out.println("执行线程");
//                }
//            }
//        }).start();

        // JDK8 简化 lambda表达式
        new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                System.out.println("执行线程");
            }
        }).start();
    }
}

