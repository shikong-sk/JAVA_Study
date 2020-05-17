package cn.skcks.myCollection;

import java.util.HashMap;

/*
    自定义 HashSet
 */
public class CustomHashSet {

    HashMap map;

    private static final Object PRESENT = new Object();

    public CustomHashSet(){
        map = new HashMap();
    }

    public void add(Object o){
        map.put(o,PRESENT);
    }

    public int size(){
        return map.size();
    }

    @Override
    public String toString() {
        if(size() == 0){
            return "[]";
        }
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append("[");
        for(Object key:map.keySet()){
            stringBuilder.append(key).append(",");
        }
        stringBuilder.setCharAt(stringBuilder.length()-1,']');

        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        CustomHashSet set = new CustomHashSet();

        System.out.println(set);

        set.add("1");
        set.add("2");
        set.add("3");

        System.out.println(set.size());
        System.out.println(set);
    }
}
