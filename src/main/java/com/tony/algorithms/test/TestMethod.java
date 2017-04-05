package com.tony.algorithms.test;

import java.util.ArrayList;
import java.util.Arrays;

import com.alibaba.algorithms.TreeNode;

public class TestMethod {

    public class ListNode {

        int      val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public static void main(String[] args) {
        StringBuffer sb = new StringBuffer("We Are Happy");
        System.out.println(replaceSpace(sb));
        int[] pre = {1,2,4,7,3,5,6,8};
        int[] in = {4,7,2,1,5,3,8,6};
        traverseBinTreeRDL(reConstructBinaryTree(pre,in));
        System.out.println(transfer("aa"));
        Arrays.sort(pre);
    }

    public static String replaceSpace(StringBuffer str) {
        if (str == null) return null;
        StringBuffer outputBuffer = new StringBuffer();
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == ' ') {
                outputBuffer.append("%20");
            } else {
                outputBuffer.append(String.valueOf(str.charAt(i)));
            }
        }
        return outputBuffer.toString();
    }

    public static ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        if (listNode != null) {
            if (listNode.next != null) {
                list = printListFromTailToHead(listNode.next);
            }
            list.add(listNode.val);
        }
        return list;
    }

    // 输入前序遍历和中序遍历结果
    public static TreeNode reConstructBinaryTree(int[] pre, int[] in) {
        TreeNode root = reConstructBinaryTree(pre, 0, pre.length - 1, in, 0, in.length - 1);
        return root;
    }

    // 前序遍历{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}
    private static TreeNode reConstructBinaryTree(int[] pre, int startPre, int endPre, int[] in, int startIn, int endIn) {
        if (startPre > endPre || startIn > endIn) return null;
        TreeNode root = new TreeNode(pre[startPre]);
        //i - startIn为长度
        for (int i = startIn; i <= endIn; i++)
            if (in[i] == pre[startPre]) {
                root.left = reConstructBinaryTree(pre, startPre + 1, startPre + i - startIn, in, startIn, i - 1);
                root.right = reConstructBinaryTree(pre, startPre + 1 + i - startIn, endPre, in, i + 1, endIn);
            }

        return root;
    }

    /**
     * 后序遍历打印二叉树
     * @param node
     * @return 
     */
    public static void traverseBinTreeRDL(TreeNode node) {
        if (node == null) {
            return;
        }
        if (node.left != null) {
            traverseBinTreeRDL(node.left);
        }
        if (node.right != null) {
            traverseBinTreeRDL(node.right);
        }
        System.out.println(node.val);
    }
    
    /**
     * 进制转换
     * @param n
     */
    public static int transfer(String n){
        int b = Integer.parseInt(n, 16);
        return b;
    }
}
