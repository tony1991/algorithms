package com.tony.algorithms.myOffer;


/**
 * 类Problem4_RebuildTree.java的实现描述：TODO 类实现描述 
 * @author tony 2015年9月20日 上午11:25:37
 * 输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。
 */
public class Pro4_RebuildTree {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { 
            val = x; 
        }
}

    public static void main(String[] args) {
        int[] pre = {1,2,4,7,3,5,6,8};
        int[] in = {4,7,2,1,5,3,8,6};
        reConstructBinaryTree(pre,in);
    }
    
    public static TreeNode reConstructBinaryTree(int [] pre,int [] in) {
        TreeNode root = reConstructBinaryTree(pre, 0, pre.length - 1, in, 0, in.length - 1);
        return root;
    }
     
    // 前序遍历{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}
    private static TreeNode reConstructBinaryTree(int[] pre, int startPre, int endPre, int[] in, int startIn, int endIn) {
        if (startPre > endPre || startIn > endIn) return null;
        TreeNode root = new TreeNode(pre[startPre]);
        //i - startIn为长度，注意区分前序遍历和中序遍历的起点和终点
        for (int i = startIn; i <= endIn; i++)
            if (in[i] == pre[startPre]) {
                root.left = reConstructBinaryTree(pre, startPre + 1, startPre + i - startIn, in, startIn, i - 1);
                root.right = reConstructBinaryTree(pre, startPre + 1 + i - startIn, endPre, in, i + 1, endIn);
            }
 
        return root;
    }
}
