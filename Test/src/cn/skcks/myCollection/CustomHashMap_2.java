package cn.skcks.myCollection;

/*
    自定义 HashMap
    新增 get 方法
 */
public class CustomHashMap_2 {
    CustomMapNode_1[] table;  // 位桶数组
    int size;

    public CustomHashMap_2() {
        table = new CustomMapNode_1[16]; // 长度定义为 2的N次方
    }

    public void put(Object key, Object value) {

        CustomMapNode_1 node = new CustomMapNode_1();

        node.hash = Hash(key.hashCode(), table.length);

        node.key = key;
        node.value = value;
        node.next = null;

        CustomMapNode_1 tmp = table[node.hash];

        CustomMapNode_1 last = null;

        boolean flag = false;

        if (tmp == null) {
            table[node.hash] = node;
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
            }
        }

    }

    public int Hash(int hash, int length) {
//        System.out.println(hash);
//        System.out.println(hash%(length-1));
//        System.out.println(hash&(length-1));
        return hash & (length - 1);
    }

    public Object get(Object key){
        int hash = Hash(key.hashCode(),table.length);

        Object value = null;

        if(table[hash] != null)
        {
            CustomMapNode_1 tmp = table[hash];
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

        for (CustomMapNode_1 customMapNode : table) {
            CustomMapNode_1 tmp = customMapNode;

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
        CustomHashMap_2 map = new CustomHashMap_2();
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
