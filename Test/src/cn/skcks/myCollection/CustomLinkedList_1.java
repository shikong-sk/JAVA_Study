package cn.skcks.myCollection;

/*
    自定义链表
 */
public class CustomLinkedList_1 {
    private CustomNode first;
    private CustomNode last;

    private int size;

    public void add(Object obj) {
        CustomNode node = new CustomNode(obj);

        if (this.first == null) {
//            node.previous = null;
//            node.next = null;
            this.first = node;
        } else {
            node.previous = last;
            node.next = null;

            last.next = node;
        }

        this.last = node;
        this.size++;
    }

    public Object get(int index) {

        checkRange(index);


        CustomNode tmp;

        if (index < (this.size >> 1)) {
            tmp = first;
            for (int i = 0; i < index; i++) {
                tmp = tmp.next;
            }
        } else {
            tmp = last;
            for (int i = this.size - 1; i > index; i--) {
                tmp = tmp.previous;
            }
        }

        return tmp.data;
    }

    private void checkRange(int index) {
        // 索引合法判断
        if (index < 0 || index > this.size - 1) {
            throw new RuntimeException("索引不合法");
        }
    }

    private int length() {
        return this.size;
    }

    @Override
    public String toString() {

        CustomNode tmp = this.first;

        if (tmp == null) {
            return "[]";
        }

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[");

        while (tmp != null) {
            stringBuilder.append(tmp.data).append(',');
            tmp = tmp.next;
        }

        stringBuilder.setCharAt(stringBuilder.length() - 1, ']');

        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        CustomLinkedList_1 list = new CustomLinkedList_1();

        list.add("0");
        list.add("1");
        list.add("2");
        list.add("3");

        System.out.println(list);

        System.out.println("链表长度：" + list.length());

        System.out.println(list.get(2));
    }
}
