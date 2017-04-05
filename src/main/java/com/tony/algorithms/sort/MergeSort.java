package com.tony.algorithms.sort;

/**
 * 类MergeSort.java的实现描述：TODO 类实现描述
 * 
 * @author tony 2015年9月4日 下午4:17:46 
 * 归并排序。
 */
public class MergeSort {

    public static void main(String[] args) {
        int[] a = { 54,35,48,36,27,12,44,44,8,14,26,17,28 };
//        mergeSort(a,0,a.length-1);
        a = mergeSort(a,a.length-1);
        printResult(a);
    }
    
    public static int[] mergeSort(int[] A, int n) {
        mergeSort(A,0,n-1);
        return A;
    }
    
    public static void mergeSort(int[] A,int left,int right){
        if(left<right){
            int center = (left+right)/2;
            mergeSort(A,left,center);
            mergeSort(A,center+1,right);
            merge(A,left,center,right);
        }
    }
    
    public static void merge(int[] A,int left,int center,int right){
        int[] tmpArray = new int[A.length]; 
        int mid = center + 1;
        int third = left; 
        int tmp = left;
        while(left<=center && mid<=right){
            if(A[left]<=A[mid]){
                tmpArray[third++] = A[left++];
            }else{
                tmpArray[third++]=A[mid++];
            }
        }
        while(mid<=right){
            tmpArray[third++] = A[mid++];
        }
        while(left<=center){
            tmpArray[third++] = A[left++];
        }
        //将中间数组中的内容复制回原数组  
        while(tmp<=right){  
            A[tmp]=tmpArray[tmp++];  
        }
    }
    
//  public static void merge(int[] data, int left, int center, int right) {
//  int [] tmpArr= new int[data.length];  
//  int mid = center+1;  
//  //third记录中间数组的索引  
//  int third = left;  
//  int tmp = left;  
//  while(left<=center && mid<=right){  
//      //从两个数组中取出最小的放入中间数组  
//      if(data[left]<=data[mid]){  
//          tmpArr[third++]=data[left++];  
//      }else{  
//          tmpArr[third++]=data[mid++];  
//      }  
//  }
//  //剩余部分依次放入中间数组  
//  while(mid<=right){  
//      tmpArr[third++]=data[mid++];  
//  }  
//  while(left<=center){  
//      tmpArr[third++]=data[left++];  
//  }  
//  //将中间数组中的内容复制回原数组  
//  while(tmp<=right){  
//      data[tmp]=tmpArr[tmp++];  
//  }  
//}
//
//    public static void mergeSort(int[] data, int left, int right) {
//        if (left < right) {
//            int center = (left + right) / 2;// 找出中间索引
//            mergeSort(data, left, center);// 对左边数组进行递归
//            mergeSort(data, center + 1, right);// 对右边数组进行递归
//            merge(data, left, center, right);// 合并
//        }
//    }
//
//    /**
//     * 每次从两个有序表a[left...center],a[center+1...high]取出一个数比较，较小的放入临时表中，直到一个表为空，再将非空表余下的复制到临时表
//     * @param data
//     * @param left
//     * @param center
//     * @param right
//     */
//    public static void merge(int[] data, int left, int center, int right) {
//        int [] tmpArr= new int[data.length];  
//        int mid = center+1;  
//        //third记录中间数组的索引  
//        int third = left;  
//        int tmp = left;  
//        while(left<=center && mid<=right){  
//            //从两个数组中取出最小的放入中间数组  
//            if(data[left]<=data[mid]){  
//                tmpArr[third++]=data[left++];  
//            }else{  
//                tmpArr[third++]=data[mid++];  
//            }  
//        }
//        //剩余部分依次放入中间数组  
//        while(mid<=right){  
//            tmpArr[third++]=data[mid++];  
//        }  
//        while(left<=center){  
//            tmpArr[third++]=data[left++];  
//        }  
//        //将中间数组中的内容复制回原数组  
//        while(tmp<=right){  
//            data[tmp]=tmpArr[tmp++];  
//        }  
//    }

    public static void printResult(int[] a) {
        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i]);
        }
    }
}
