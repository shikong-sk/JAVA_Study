package cn.skcks.oop;

import java.util.HashMap;
import java.util.Map;

/*
    HashMap
 */
public class TestMap2 {
    public static void main(String[] args) {
        User u1 = new User(1001, "时空");
        User u2 = new User(1002, "时间");
        User u3 = new User(1003, "时光");

        Map<Integer, User> map = new HashMap<>();

        map.put(1001, u1);
        map.put(1002, u2);
        map.put(1003, u3);

        System.out.println(map);

        for (Integer tmp : map.keySet()) {
            System.out.println(tmp + " : " + map.get(tmp).getName());
        }

    }
}

class User {
    private int id;
    private String name;

    public User(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
