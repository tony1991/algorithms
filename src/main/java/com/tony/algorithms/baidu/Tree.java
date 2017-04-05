package com.tony.algorithms.baidu;

import java.util.List;

public class Tree {
    public class TreeNode {
        int val = 0;
        TreeNode leftChild = null;
        TreeNode rightChild = null;

        public TreeNode(int val) {
            this.val = val;
        }
    }
    
    private int[] array = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };  
    private static List<TreeNode> nodeList = null;  
    /*
    public static void main(String[] args) {
        Tree binTree = new Tree();  
        binTree.createBinTree();  
        // nodeList中第0个索引处的值即为根节点  
        Node root = nodeList.get(0);  
  
        System.out.println("先序遍历：");  
        preOrderTraverse(root);  
        System.out.println();  
  
        System.out.println("中序遍历：");  
        inOrderTraverse(root);  
        System.out.println();  
  
        System.out.println("后序遍历：");  
        postOrderTraverse(root);  
    }
    */
    //先序遍历
    public static void preOrder(TreeNode node){
        if (node == null)  
            return;  
        System.out.print(node.val + " ");
        preOrder(node.leftChild);
        preOrder(node.rightChild);
    }
 
  //前序遍历的非递归实现  
    /*
    public void nonRecPreOrder(TreeNode p){  
        Stack<TreeNode> stack=new Stack<TreeNode>();  
        TreeNode node=p;  
        while(node!=null||stack.size()>0){  
            while(node!=null){  
                visted(node);  
                stack.push(node);  
                node=node.leftChild;  
            }  
            while(stack.size()>0){  
                node=stack.pop();  
                node=node.rightChild;  
            }   
        }  
    }  
    */
}
