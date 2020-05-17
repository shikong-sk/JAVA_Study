package cn.skcks.myCollection;

/*
    自定义链表节点
 */

public class CustomNode{

    public CustomNode previous;
    public Object data;
    public CustomNode next;

    public CustomNode(CustomNode previous, CustomNode data, CustomNode next) {
        this.previous = previous;
        this.data = data;
        this.next = next;
    }

    public CustomNode(Object data) {
        this.data = data;
    }
}
