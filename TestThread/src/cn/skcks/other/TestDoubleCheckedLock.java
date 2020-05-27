package cn.skcks.other;

/*
    单例模式

    DCL

    懒汉式 + 多线程并发

    多线程环境下，对外只提供一个对象

    1.构造器私有化 避免外部 new 构造器
    2.提供私有静态属性 存储对象的地址
    3.提供公共的静态方法 获取属性值
 */
public class TestDoubleCheckedLock {

    // 构造器私有化
    private TestDoubleCheckedLock() {
    }

    // 提供私有静态属性
    // volatile 避免指令重排
    private volatile static TestDoubleCheckedLock testDoubleCheckedLock;

    public static TestDoubleCheckedLock getTestDoubleCheckedLock() {
        // 双重检测 避免等待
        if (testDoubleCheckedLock != null) {
            return testDoubleCheckedLock;
        }

        synchronized (TestDoubleCheckedLock.class) {
            if (testDoubleCheckedLock == null) {
                // new 操作 => 开辟空间、初始化对象、返回对象地址
                // 在初始化完成 返回对象地址之前 可能出现指令重排
                // 其他线程可能访问到一个空对象
                // 可使用 volatile 避免
                testDoubleCheckedLock = new TestDoubleCheckedLock();
            }
            return testDoubleCheckedLock;
        }
    }

    public static TestDoubleCheckedLock getTestDoubleCheckedLock(long time) {
        // 双重检测 避免等待
        if (testDoubleCheckedLock != null) {
            return testDoubleCheckedLock;
        }

        synchronized (TestDoubleCheckedLock.class) {
            if (testDoubleCheckedLock == null) {
                // new 操作 => 开辟空间、初始化对象、返回对象地址
                // 在初始化完成 返回对象地址之前 可能出现指令重排
                // 其他线程可能访问到一个空对象
                // 可使用 volatile 避免

                // 模拟网络延迟
                try {
                    Thread.sleep(time);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                testDoubleCheckedLock = new TestDoubleCheckedLock();
            }
            return testDoubleCheckedLock;
        }
    }

    public static TestDoubleCheckedLock getTestDoubleCheckedNoLock(long time) {
        // 模拟未同步执行并发时的情况
        if (testDoubleCheckedLock == null) {
            try {
                Thread.sleep(time);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            testDoubleCheckedLock = new TestDoubleCheckedLock();
        }
        return testDoubleCheckedLock;

    }

    public static void setTestDoubleCheckedLock(TestDoubleCheckedLock testDoubleCheckedLock) {
        TestDoubleCheckedLock.testDoubleCheckedLock = testDoubleCheckedLock;
    }

    public static void main(String[] args) {
        // 未同步 数据不一致
        Thread A = new Thread(() -> System.out.println(TestDoubleCheckedLock.getTestDoubleCheckedNoLock(250)));
        A.start();
        System.out.println(TestDoubleCheckedLock.getTestDoubleCheckedNoLock(500));

        // 同步
        Thread B = new Thread(() -> System.out.println(TestDoubleCheckedLock.getTestDoubleCheckedLock(250)));
        B.start();
        System.out.println(TestDoubleCheckedLock.getTestDoubleCheckedLock(500));
    }
}
