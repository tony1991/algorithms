package com.tony.algorithms.baseStruct;

public class LinkedList<T> {

    public LinkNode<T> head;     // 链表的表头
    int                 size = 0; // 链表长度

    /**
     * 构造函数，初始化
     */
    public LinkedList() {
    }

    /**
     * 插入节点。尾插法
     * 
     * @return
     */
    public void tairAdd(T t) {
        LinkNode<T> node = new LinkNode<T>(t, null);// 新节点
        LinkNode<T> p = head;
        // 注意链表为空的时候的插入
        if (head == null) {
            head = node;
        } else {
            while (p.next != null) {
                p = p.next;
            }
            p.next = node;
        }
        size++;
    }


    /**
     * 删除节点
     * 
     * @return
     */
    public void deleteNode(int i) {
        LinkNode<T> t = getNode(i);
        if(t==null){
            System.out.print("第"+i+"个节点不存在"); 
        }else{
            
        }
    }
    
    /**
     * 查找节点
     * 
     * @return
     */
    public LinkNode<T> getNode(int i) {
        LinkNode<T> p = head;
        int j = 0;
        while(p.next!=null && j<i){
            p = p.next;
            j++;
        }
        if(j==i) return p;
        else return null;
    }
    
    /**
     * 链表长度
     * 
     * @return
     */
    public int size() {
        return size;
    }

    /**
     * 显示出所有的节点信息
     */
    public void displayAllNodes() {
        LinkNode<T> current = head;
        while (current != null) {
            current.display();
            current = current.next;
        }
        System.out.println();
    }
    
}
