package cn.skcks.oop;

import java.util.HashSet;
import java.util.Set;

/*
    HashSet
    继承 自 Collection
    Set 没有顺序，不可重复
 */
public class TestHashSet {
    public static void main(String[] args) {
        Set<String> set1 = new HashSet<>();

        set1.add("1");
        set1.add("2");
        set1.add("3");

        System.out.println(set1);

        set1.remove("3");

        System.out.println(set1);

        Set<String> set2 = new HashSet<>();

        set2.add("0");
        set2.add("1");

        System.out.println(set2);

        set1.addAll(set2);

        System.out.println(set1);

    }
}
