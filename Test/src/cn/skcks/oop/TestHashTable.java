package cn.skcks.oop;

import java.util.Hashtable;
import java.util.Map;

/*
    HashTable
    线程安全,效率低
    key 或 value 不允许为空
 */
public class TestHashTable {
    public static void main(String[] args) {
        Map<Integer,String> map = new Hashtable<>();
    }
}
