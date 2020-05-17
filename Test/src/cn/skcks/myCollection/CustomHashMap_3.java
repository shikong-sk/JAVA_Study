package cn.skcks.myCollection;

/*
    自定义 HashMap
    新增 get 方法
    新增泛型
 */
public class CustomHashMap_3<K,V> {
    CustomMapNode_2<K,V>[] table;  // 位桶数组
    int size;

    public CustomHashMap_3() {
        table = new CustomMapNode_2[16]; // 长度定义为 2的N次方
    }

    public void put(K key, V value) {

        CustomMapNode_2<K,V> node = new CustomMapNode_2<K,V>();

        node.hash = Hash(key.hashCode(), table.length);

        node.key = key;
        node.value = value;
        node.next = null;

        CustomMapNode_2<K,V> tmp = table[node.hash];

        CustomMapNode_2<K,V> last = null;

        boolean flag = false;

        if (tmp == null) {
            table[node.hash] = node;
            size++;
        } else {
            while (tmp != null) {
                if (tmp.key.equals(node.key)) {
//                    System.out.println("键名重复");

                    flag = true;
                    tmp.value = value;

                    break;
                } else {
                    last = tmp;
                    tmp = tmp.next;
                }
            }

            if (!flag) {
                last.next = node;

                size++;
            }
        }

    }

    public int Hash(int hash, int length) {
//        System.out.println(hash);
//        System.out.println(hash%(length-1));
//        System.out.println(hash&(length-1));
        return hash & (length - 1);
    }

    public V get(K key){
        int hash = Hash(key.hashCode(),table.length);

        V value = null;

        if(table[hash] != null)
        {
            CustomMapNode_2<K,V> tmp = table[hash];
            while (tmp != null)
            {
                if(tmp.key.equals(key)){
                    value = tmp.value;
                    break;
                }
                else{
                    tmp = tmp.next;
                }
            }
        }

        return value;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append("{");

        for (CustomMapNode_2<K,V> customMapNode : table) {
            CustomMapNode_2<K,V> tmp = customMapNode;

            while (tmp != null) {
                stringBuilder.append(tmp.key).append(" => ").append(tmp.value).append(",");
                tmp = tmp.next;
            }
        }

        if (stringBuilder.length() > 1) {
            stringBuilder.setCharAt(stringBuilder.length() - 1, '}');
        }
        else{
            stringBuilder.append("}");
        }

        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        CustomHashMap_3<Integer, String> map = new CustomHashMap_3<>();
        System.out.println(map);

        map.put(64, "64");
        map.put(65, "65");
        map.put(66, "66");

        System.out.println(map);

        map.put(10000, "时空");
        map.put(10001, "时间");
        map.put(10002, "时光");

        System.out.println(map);

        map.put(10002, "BB");

        System.out.println(map);

        System.out.println(map.get(10000));
        System.out.println(map.get(10001));
        System.out.println(map.get(10002));

    }
}
