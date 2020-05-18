package cn.skcks.oop;

import java.util.Set;
import java.util.TreeSet;

/*
    TreeSet
 */
public class TestTreeSet {
    public static void main(String[] args) {
        Set<Integer> set = new TreeSet<>();

        set.add(100);
        set.add(200);
        set.add(300);

        for (Integer v : set) {
            System.out.println(v);
        }

        Set<User2> set2 = new TreeSet<>();

        set2.add(new User2(100,"时空"));
        set2.add(new User2(101,"时间"));
        set2.add(new User2(101,"时光"));

        for (User2 v : set2) {
            System.out.println(v);
        }
    }
}

class User2 implements Comparable<User2> {
    int id;
    String name;

    public User2(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public int compareTo(User2 o) {
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
        return "User2{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}