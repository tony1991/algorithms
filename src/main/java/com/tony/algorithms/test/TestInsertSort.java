package com.tony.algorithms.test;
//插入排序分为直接插入排序和折半插入排序，以及希尔排序
public class TestInsertSort {

    public static void main(String[] args) {
        int[] a = { 49, 38, 65, 97, 76, 13, 27, 49, 78, 34, 12, 64, 5, 4, 62, 99, 98, 54, 56, 17, 18, 23, 34, 15, 35,
                    25, 53, 51 };
//      //初始
//        if(a.length>0){
//            quickTest(a,0,a.length-1);
//        }
        maopao(a);
        printResult(a);
    }
    
    public static void quickTest(int[] a, int low, int high){
            if(low<high){
                int mid = getMiddle(a,low,high);
                quickTest(a,low,mid-1);
                quickTest(a,mid+1,high);
            }
    }
    
    public static int getMiddle(int[] a,int low,int high){
        int temp = a[low];
        while(low<high)
        {
            while(low<high && a[high]>=temp){
                high--;
            }
            a[low] = a[high];
            while(low<high && a[low] <=temp){
                low++;
            }
            a[high] = a[low];
        }
        a[low] = temp;
        return low;
   }
    
    public static void maopao(int[] a){
        int temp = 0;
        for(int i=a.length-1;i>0;i--){
            int swap = 0;
            for(int j=0;j<i;j++){
                if (a[j] > a[j + 1]) {
                    swap = 1;
                    temp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = temp;
                }
            }
            if(swap ==0) break;
        }
    }
    
    private static void testInsertSort(int[] a) {
        int temp = 0;
        for(int i=1;i<a.length;i++){
            if(a[i]<a[i-1]){
                temp = a[i];
                int j=i-1;
                for(;j>=0 && temp<a[j];j--){
                    a[j+1] = a[j];
                }
                a[j+1] = temp;
            }
        }
    }
    public static void halfInsertSort(int[] a) {
        int temp = 0;
        for (int i = 1; i < a.length; i++) {
            temp = a[i];
            // 设置初始区间
            int low = 0;
            int mid = 0;
            int high = i - 1;
            // 寻找插入位置high+1
            while (low <= high) {
                mid = (low + high) / 2;
                if (temp > a[mid]) {
                    low = mid + 1; // 高半区
                } else {
                    high = mid - 1; // 低半区
                }
            }
            // 插入点之后的元素全部移动一位
            for (int j = i - 1; j >= high + 1; j--) {
                a[j + 1] = a[j];
            }
            // 插入元素
            a[high + 1] = temp;
        }
    }

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
