package cn.skcks.myCollection;

import java.util.LinkedList;

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
