package cn.skcks.myCollection;

//import java.util.Arrays;

/*
 * 自定义ArrayList
 */
public class CustomArrayList_1 {
    private Object[] elementData = null;
    private int size;

    private static final int DEFAULT_CAPACITY = 10;

    public CustomArrayList_1() {
        elementData = new Object[DEFAULT_CAPACITY];
    }

    public CustomArrayList_1(int capacity) {
        elementData = new Object[capacity];
    }

    public int size() {
        return size;
    }

    public void add(Object object) {
        elementData[size++] = object;
    }

    @Override
    public String toString() {
//        return "CustomArrayList{" +
//                "elementData=" + Arrays.toString(elementData) +
//                ", size=" + size +
//                '}';
        if (size == 0){
            return "[]";
        }


        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[");

//        for (Object object : elementData) {
//            stringBuilder.append(object).append(",");
//        }

        for (int i = 0; i < size; i++) {
            stringBuilder.append(elementData[i]).append(',');
        }

//        stringBuilder.delete(stringBuilder.length()-1,stringBuilder.length());
//        stringBuilder.append("]");
        stringBuilder.setCharAt(stringBuilder.length()-1,']');

        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        CustomArrayList_1 list = new CustomArrayList_1();

        list.add("1");
        list.add("2");

        System.out.println(list.size());

        System.out.println(list);
    }

}
