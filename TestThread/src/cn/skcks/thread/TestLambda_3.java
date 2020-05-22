package cn.skcks.thread;

/*
    Lambda 表达式

    单个方法的接口 可使用 lambda

    带参数 lambda
 */
public class TestLambda_3 {
    static class fan implements Computers {
        @Override
        public void lambda(String name) {
            System.out.println(name);
        }
    }

    public static void main(String[] args) {
        // 外部类
        Computers cpu = new CPUs();
        cpu.lambda("处理器");

        // 内部类
        Computers fan = new fan();
        fan.lambda("散热器");

        // 局部内部类
        new Computers() {
            @Override
            public void lambda(String name) {
                System.out.println(name);
                System.out.println("system");
            }
        }.lambda("系统");

        // lambda
        Computers disk;
        disk = (name) -> {
            System.out.println(name);
            System.out.println("disk");
        };
        disk.lambda("硬盘");

        // 单个参数时可 再简化
        Computers display;
        display = name -> System.out.println(name);
        display.lambda("显示器");

        // 调用方法为静态方法时 可 最简化
        Computers mouse;
        mouse = System.out::println;
        mouse.lambda("鼠标");
    }
}

interface Computers {
    void lambda(String name);
}

class CPUs implements Computers {
    @Override
    public void lambda(String name) {
        System.out.println(name);
    }
}