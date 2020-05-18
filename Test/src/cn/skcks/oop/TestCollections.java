package cn.skcks.oop;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
    Collections 工具类
 */
public class TestCollections {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();

        for (int i = 0; i < 3; i++) {
            list.add(String.valueOf(i));
        }

        System.out.println(list);

        // 逆序排列
        Collections.reverse(list);
        System.out.println(list);

        // 随机排列
        Collections.shuffle(list);
        System.out.println(list);

        // 递增排序
        Collections.sort(list);
        System.out.println(list);

        // 二分法查找
        System.out.println(Collections.binarySearch(list,"2"));

    }
}
