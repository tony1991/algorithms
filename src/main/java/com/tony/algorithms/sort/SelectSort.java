package com.tony.algorithms.sort;

/**
 * 类SelectSort.java的实现描述：TODO 类实现描述
 * 
 * @author tony 2015年9月4日 上午11:51:04 
 * 选择排序分为简单选择排序和堆排序。
 */
public class SelectSort {

    public static void main(String[] args) {
        int[] a = { 49, 38, 65, 97, 76, 13, 27, 49, 78, 34, 12, 64, 5, 4, 62, 99, 98, 54, 56, 17, 18, 23, 34, 15, 35,
                25, 53, 51 };
        // simpleSelectSort(a);
        heapSort(a);
        printResult(a);
    }

    /**
     * 简单选择排序。 
     * 不稳定排序，时间复杂度为O(n2) 关键是找到最小元素的下标，然后替换
     * @param a
     */
    public static void simpleSelectSort(int[] a) {
        int temp = 0;
        for (int i = 0; i < a.length; i++) {
            int k = i; // 用来记录每一趟的最小元素下标，默认为每一趟第一个元素
            for (int j = i + 1; j < a.length; j++) {
                if (a[j] < a[k]) {
                    k = j; // 找到最小元素下标
                }
            }
            // 替换。将最小元素和每趟第一个元素交换,当然如果每趟第一个元素就是最小元素，就没必要交换
            if (i != k) {
                temp = a[i];
                a[i] = a[k];
                a[k] = temp;
            }
        }
    }

    /**
     * 堆排序。主要是对简单选择排序的改进，将一些有用的信息保留下来。 
     * 堆排序主要分为两个步骤：建初始堆和筛选。最后合在一起是排序，即堆顶元素和堆底元素交换
     * @param a
     */
    public static void heapSort(int[] a) {
        buildHeap(a);//构建初始堆
        int n = a.length;
        int i=0;
        for(i=n-1;i>=1;i--){
            swap(a,0,i);
            heapAdjust(a,0,i);
        }
    }

    public static void buildHeap(int[] array){
        int n = array.length;//数组中元素的个数
        for(int i=(n-1)/2;i>=0;i--)
            heapAdjust(array,i,n);
    }
    
    public static void heapAdjust(int[] A,int idx,int max){
        int left = 2*idx+1;// 左孩子的下标（如果存在的话）
        int right =2*idx+2;// 左孩子的下标（如果存在的话）
        int largest = 0;//寻找3个节点中最大值节点的下标
        if(left<max && A[left]>A[idx])
            largest = left;
        else
            largest = idx;
        if(right<max && A[right]>A[largest])
            largest = right;
        if(largest!=idx){
            swap(A,largest,idx);
            heapAdjust(A,largest,max);            
        }    
    }
    
    /*
    public static void heapSort(int[] a) {
        int arrayLength = a.length;
        // 循环建堆
        for (int i = 0; i < arrayLength - 1; i++) {
            // 筛选
            heapAdjust(a, arrayLength - 1 - i);
            // 交换堆顶和最后一个元素
            swap(a, 0, arrayLength - 1 - i);
        }
    }
    */
    
    /**
     * @param data
     * @param lastIndex 最后一个元素的下标
     */
    /*
    public static void heapAdjust(int[] data, int lastIndex) {
        // 从lastIndex处节点（最后一个节点）的父节点开始
        for (int i = (lastIndex - 1) / 2; i >= 0; i--) {
            // k保存正在判断的节点
            int k = i;
            // 如果当前k节点的子节点存在，完全二叉树可以根据2k+1获取左右子树节点
            while (k * 2 + 1 <= lastIndex) {
                // k节点的左子节点的索引
                int biggerIndex = 2 * k + 1;
                // 如果biggerIndex小于lastIndex，即biggerIndex+1代表的k节点的右子节点存在
                if (biggerIndex < lastIndex) {
                    // 若果右子节点的值较大
                    if (data[biggerIndex] < data[biggerIndex + 1]) {
                        // biggerIndex总是记录较大子节点的索引
                        biggerIndex++;
                    }
                }
                // 如果k节点的值小于其较大的子节点的值
                if (data[k] < data[biggerIndex]) {
                    // 交换他们
                    swap(data, k, biggerIndex);
                    // 将biggerIndex赋予k，开始while循环的下一次循环，重新保证k节点的值大于其左右子节点的值
                    k = biggerIndex;
                } else {
                    break;
                }
            }
        }
    }
     */
    /**
     * 交换数组中的两个数
     * 
     * @param data
     * @param i
     * @param j
     */
    private static void swap(int[] data, int i, int j) {
        int tmp = data[i];
        data[i] = data[j];
        data[j] = tmp;
    }

    public static void printResult(int[] a) {
        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i]);
        }
    }
}
