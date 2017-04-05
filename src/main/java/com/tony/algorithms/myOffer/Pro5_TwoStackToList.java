package com.tony.algorithms.myOffer;

import java.util.Stack;

/**
 * 类Pro5_TwoStackToList.java的实现描述：TODO 类实现描述 
 * @author tony 2015年9月20日 上午11:27:59
 * 用两个栈来实现一个队列，完成队列的Push和Pop操作。 队列中的元素为int类型。
 */
public class Pro5_TwoStackToList {
    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();
    
    public void push(int node) {
        stack1.push(new Integer(node));
    }
    
    public int pop() {
        while(!stack2.isEmpty()){
            return stack2.pop().intValue();
        }
        while(!stack1.isEmpty()){
            stack2.push(stack1.pop().intValue());
        }
        return stack2.pop().intValue();
    }
    
    public static void main(String[] args) {
        
    }
}
