package cn.skcks.myCollection;

/*
 * 自定义ArrayList
 * 增加泛型
 */
public class CustomArrayList_2<E> {
    private Object[] elementData = null;
    private int size;

    private static final int DEFAULT_CAPACITY = 10;

    public CustomArrayList_2() {
        elementData = new Object[DEFAULT_CAPACITY];
    }

    public CustomArrayList_2(int capacity) {
        elementData = new Object[capacity];
    }

    public int size() {
        return size;
    }

    public void add(E element) {

        if (size == elementData.length) {

            // 数组扩容

//            Object[] newElementData = new Object[elementData.length << 1];    // 扩容2倍
            Object[] newElementData = new Object[elementData.length + (elementData.length >> 1)];    // 扩容1.5倍

            System.arraycopy(elementData, 0, newElementData, 0, elementData.length);

            elementData = newElementData;
        }

        elementData[size++] = element;
    }

    @Override
    public String toString() {

        if (size == 0) {
            return "[]";
        }

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[");

        for (int i = 0; i < size; i++) {
            stringBuilder.append(elementData[i]).append(',');
        }

        stringBuilder.setCharAt(stringBuilder.length() - 1, ']');

        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        CustomArrayList_2<Object> list = new CustomArrayList_2<>();

        for (int i = 0; i < 20; i++) {
            list.add(i);
        }

        System.out.println(list.size());

        System.out.println(list);
    }

}
