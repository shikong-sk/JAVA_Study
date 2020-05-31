package cn.skcks.server.basic;

import java.lang.reflect.InvocationTargetException;

/*
    反射：将 Java 类中的各种结构 (方法、属性、构造器、类名) 映射为 Java 对象

    1.获取 Class 对象         推荐 Class.forName("包名.类名$内部类");
    2.动态创建对象            推荐  对象.getConstructor().newInstance();
 */
public class TestReflect {
    public static void main(String[] args) {
        // 三种方法
        // 1. 对象.getClass()
        aClass a = new aClass();
        Class A = a.getClass();

        // 2. 类.class
        A = aClass.class;

        // 3.Class.forName("包名.类名");
        try {
            A = Class.forName("cn.skcks.server.basic.TestReflect$aClass");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        // 创建对象
        try {
            // JDK 9 中废弃
            aClass a1 = (aClass) A.newInstance();
        } catch (InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }

        // 推荐方式
        try {
            aClass a2 = (aClass) A.getConstructor().newInstance();
            System.out.println(a2);
            System.out.println(a2.getClass().getPackage()); // 获取类名
            System.out.println(a2.getClass().getName());    // 获取包名
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
            e.printStackTrace();
        }

    }
    static class aClass{
        public aClass() {
        }
    }
}

