package cn.skcks.oop;

import java.util.Map;
import java.util.TreeMap;

/*
    TreeMap
 */
public class TestTreeMap {
    public static void main(String[] args) {
        Map<Integer, String> map1 = new TreeMap<>();

        map1.put(0, "0");
        map1.put(1, "1");
        map1.put(2, "2");

        // 按照 key 值递增排序
        for (Integer key : map1.keySet()) {
            System.out.println(key + " => " + map1.get(key));
        }

        Map<User1, String> map2 = new TreeMap<>();

        map2.put(new User1(100, "时空"), "AAA");
        map2.put(new User1(101, "时间"), "BBB");
        map2.put(new User1(102, "时长"), "XXX");
        map2.put(new User1(102, "时光"), "CCC");

        for (User1 key : map2.keySet()) {
            System.out.println(key + " => " + map2.get(key));
        }

    }
}

class User1 implements Comparable<User1> {
    int id;
    String name;

    public User1(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public int compareTo(User1 o) {
        if (this.id > o.id) {
            return 1;
        } else if (this.id < o.id) {
            return -1;
        } else {
            return (this.name.compareTo(o.name));
        }
    }

    @Override
    public String toString() {
        return "User1{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}