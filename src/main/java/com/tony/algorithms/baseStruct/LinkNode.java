package com.tony.algorithms.baseStruct;

/**
 * 类LinkNode.java的实现描述：TODO 类实现描述
 * 
 * @author tony 2015年9月10日 上午9:24:49 链表节点
 */
public class LinkNode<T> {

    T           data;
    LinkNode<T> next;

    LinkNode(T data, LinkNode<T> next) {
        this.data = data;
        this.next = next;
    }

    // 显示此节点
    public void display() {
        System.out.print(data + " ");
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public LinkNode<T> getNext() {
        return next;
    }

    public void setNext(LinkNode<T> next) {
        this.next = next;
    }

}
