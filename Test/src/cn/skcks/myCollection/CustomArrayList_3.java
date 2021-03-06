package cn.skcks.myCollection;

/*
 * 自定义ArrayList
 * 增加泛型
 * 增加 get 和 set 方法
 * 增加 数组边界检查
 */
public class CustomArrayList_3<E> {
    private Object[] elementData;
    private int size;

    private static final int DEFAULT_CAPACITY = 10;

    public CustomArrayList_3() {
        elementData = new Object[DEFAULT_CAPACITY];
    }

    public CustomArrayList_3(int capacity) {
        // 容器大小合法判断
        if (capacity < 0) {
            throw new RuntimeException("容器大小不合法");
        } else if (capacity == 0) {
            elementData = new Object[DEFAULT_CAPACITY];
        } else {

            elementData = new Object[capacity];
        }
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

    public E get(int index) {
        checkRange(index);

        return (E) elementData[index];
    }

    public void set(int index, E element) {
        checkRange(index);

        elementData[index] = element;
    }

    private void checkRange(int index) {
        // 索引合法判断
        if (index < 0 || index > size - 1) {
            throw new RuntimeException("索引不合法");
        }
    }

    public int length(){
        return elementData.length;
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
        CustomArrayList_3<Object> list = new CustomArrayList_3<>(10);

        System.out.println("容器大小：" + list.length());

        // 默认 10
        // 第一次扩容 10 + (10/2)
        // 第二次扩容 (10 + (10/2)) + ((10 + (10/2))/2)
        for (int i = 0; i < 20; i++) {
            list.add(i);
        }

        System.out.println("容器元素个数：" + list.size());
        System.out.println("容器大小：" + list.length());

        System.out.println(list);

        System.out.println(list.get(0));
        list.set(0, "A");
        System.out.println(list);

        // 索引越界抛出异常
        list.set(20, "X");
    }

}
