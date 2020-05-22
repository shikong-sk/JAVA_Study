package cn.skcks.thread;

/*
    Lambda 表达式

    单个方法的接口 可使用 lambda
 */
public class TestLambda_2 {
    static class fan implements Computer{
        @Override
        public void lambda() {
            System.out.println("fan");
        }
    }

    public static void main(String[] args) {
        // JDK8 简化 lambda表达式
        new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                System.out.println("执行线程");
            }
        }).start();

        // 外部类
        Computer cpu = new CPU();
        cpu.lambda();

        // 内部类
        Computer fan = new fan();
        fan.lambda();

        // 局部内部类
        new Computer(){
            @Override
            public void lambda() {
                System.out.println("system");
            }
        }.lambda();

        // lambda
        Computer disk;
        disk = ()-> System.out.println("disk");
        disk.lambda();
    }
}

interface Computer{
    void lambda();
}

class CPU implements Computer{
    @Override
    public void lambda() {
        System.out.println("CPU");
    }
}