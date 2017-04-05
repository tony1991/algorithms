package com.tony.algorithms.baseStruct;

public class BaseTest {

    public static void main(String[] args) {
        linkedListTest();
    }

    private static void linkedListTest() {
        LinkedList lTest = new LinkedList();
        lTest.tairAdd("a");
        lTest.tairAdd("b");
        lTest.tairAdd("c");
        lTest.tairAdd("d");
        reverse(lTest);
        // lTest.getNode(0).display();
        lTest.displayAllNodes();
        displayKthItemsBackWard(lTest.head,2);
        // 调用反转方法
        LinkNode head = ReverseList(lTest.head);
        System.out.println("\n**************************");
        // 打印反转后的结果
        while (null != head) {
            System.out.print(head.getData() + " ");
            head = head.getNext();
        }
        
    }

    /**
     * 头结点不是元素的逆序
     * 
     * @param list
     */
    public static void reverse(LinkedList list) {
        LinkNode p, q;
        p = list.head.next;
        list.head.next = null;
        while (p != null) {
            q = p;
            p = p.next;
            q.next = list.head.next;
            list.head.next = q;
        }
    }

    /**
     * 递归，在反转当前节点之前先反转后续节点
     */
    public static LinkNode reverse2(LinkNode head) {
        if (null == head || null == head.getNext()) {
            return head;
        }
        LinkNode reversedHead = reverse2(head.getNext());
        head.getNext().setNext(head);
        head.setNext(null);
        return reversedHead;
    }

    public static LinkNode ReverseList(LinkNode head) {
        if (head == null) return null;
        LinkNode reversedHead = null;
        LinkNode current = head;
        LinkNode tmp = null;
        LinkNode pre = null;
        while (current != null) {
            tmp = current.next;
            current.next = pre;
            if (tmp == null) reversedHead = current;
            pre = current;
            current = tmp;
        }
        return reversedHead;
    }
    
    /* 
     * 第 13 题：题目：输入一个单向链表，输出该链表中倒数第 k 个节点 
     */  
    public static void displayKthItemsBackWard(LinkNode head,int k){  
        LinkNode p1=head,p2=head;  
        while(--k>0){  
            p1=p1.next;  
        }  
        while(p1.next!=null){  
            p1=p1.next;  
            p2=p2.next;  
        }  
        System.out.println(p2.data);  
    }  
}
