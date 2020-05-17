package cn.skcks.myCollection;

/*
    自定义链表
    新增 remove 方法
 */
public class CustomLinkedList_2 {
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

    public CustomNode getNode(int index){
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

        return tmp;
    }

    public Object get(int index) {

        checkRange(index);

        return getNode(index).data;
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

    public void remove(int index){
        checkRange(index);

        CustomNode tmp = getNode(index);

        if(tmp != null){
            CustomNode prev = tmp.previous;
            CustomNode next = tmp.next;

            if (prev != null)
            {
                prev.next = next;
            }

            if(next != null)
            {
                next.previous = prev;
            }

            if (index == 0){
                this.first = next;
            }

            if(index == this.size - 1)
            {
                this.last = prev;
            }

            size--;
        }

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
        CustomLinkedList_2 list = new CustomLinkedList_2();

        list.add("0");
        list.add("1");
        list.add("2");
        list.add("3");

        System.out.println(list);

        System.out.println("链表长度：" + list.length());

        System.out.println(list.get(2));

        list.remove(0);
        System.out.println(list);
    }
}
