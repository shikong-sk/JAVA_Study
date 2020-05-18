package cn.skcks.oop;


import java.util.*;

/*
    Iterator 迭代器
 */
public class TestIterator {
    public static void main(String[] args) {
        iteratorList();

        iteratorSet();

        iteratorMap_1();

        iteratorMap_2();
    }

    public static void iteratorList(){
        List<String> list = new ArrayList<>();

        for (int i = 0; i < 3; i++) {
            list.add(String.valueOf(i));
        }

        System.out.println("Iterator 遍历 List");

        // 使用 Iterator 遍历 List
        for (Iterator<String> iter = list.iterator(); iter.hasNext();){
            String tmp = iter.next();
            System.out.println(tmp);
        }
    }

    public static void iteratorSet(){
        Set<String> set = new HashSet<>();

        for (int i = 0; i < 3; i++) {
            set.add(String.valueOf(i));
        }

        System.out.println("Iterator 遍历 Set");

        // 使用 Iterator 遍历 Set
        for (Iterator<String> iter = set.iterator();iter.hasNext();){
            String tmp = iter.next();
            System.out.println(tmp);
        }
    }

    public static void iteratorMap_1(){
        Map<Integer,String> map = new HashMap<>();

        for (int i = 0; i < 3; i++) {
            map.put(i,String.valueOf(i));
        }

        System.out.println("Iterator 遍历 Map 方法1");

        Set<Map.Entry<Integer,String>> mapSet = map.entrySet();

        // 使用 Iterator 遍历 Map
        for (Iterator<Map.Entry<Integer,String>> iter = mapSet.iterator();iter.hasNext();){
            Map.Entry<Integer,String> tmp = iter.next();

//            System.out.println(tmp);
            System.out.println(tmp.getKey() + " => " + tmp.getValue());
        }
    }

    public static void iteratorMap_2(){
        Map<Integer,String> map = new HashMap<>();

        for (int i = 0; i < 3; i++) {
            map.put(i,String.valueOf(i));
        }

        System.out.println("Iterator 遍历 Map 方法2");

        Set<Integer> mapSet = map.keySet();

        // 使用 Iterator 遍历 Map
        for (Iterator<Integer> iter = mapSet.iterator();iter.hasNext();){
            Integer key = iter.next();

//            System.out.println(tmp);
            System.out.println(key + " => " + map.get(key));
        }
    }
}
