package cn.skcks.myCollection;

/*
    自定义 HashMap 节点
    添加泛型
 */
public class CustomMapNode_2<K,V> {
    int hash;
    K key;
    V value;
    CustomMapNode_2<K,V> next;
}
