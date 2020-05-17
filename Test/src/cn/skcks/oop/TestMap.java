package cn.skcks.oop;

import java.util.HashMap;
import java.util.Map;

/*
    HashMap
 */
public class TestMap {
    public static void main(String[] args) {
        Map<Integer,String> m1 = new HashMap<>();

        m1.put(0,"A");
        m1.put(1,"B");
        m1.put(2,"C");

        System.out.println(m1.get(2));
        System.out.println(m1.size());
        System.out.println(m1.isEmpty());
        System.out.println(m1.toString());

        System.out.println(m1.containsKey(0));
        System.out.println(m1.containsValue("B"));

        Map<Integer,String> m2 = new HashMap<>();
        m2.put(2,"X");
        m2.put(3,"D");
        m2.put(4,"E");
        System.out.println(m2.toString());

        m1.putAll(m2);
        System.out.println(m1);
    }
}
