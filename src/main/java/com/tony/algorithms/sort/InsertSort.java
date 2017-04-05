package com.tony.algorithms.sort;

/**
 * 类InsertSort.java的实现描述：TODO 类实现描述 
 * 插入排序分为直接插入排序、折半插入排序、希尔排序
 * @author tony 2015年9月4日 上午10:43:10
 */
public class InsertSort {

    public static void main(String[] args) {
        int[] a = { 49, 38, 65, 97, 76, 13, 27, 49, 78, 34, 12, 64, 5, 4, 62, 99, 98, 54, 56, 17, 18, 23, 34, 15, 35,
                25, 53, 51 };
        //insertSort(a);
        //halfInsertSort(a);
        shellSoet(a);
        printResult(a);
    }

    /**
     * 直接插入排序。
     * 基本思想类似于插扑克牌，主要是 从后往前 排 
     * 时间复杂度为O(n2)
     * @param a
     */
    public static void insertSort(int[] a) {
        int temp = 0;
        for (int i = 1; i < a.length; i++) {
            if (a[i] < a[i - 1]) {
                temp = a[i];        
                int j = i - 1;
                for (; j >= 0 && temp < a[j]; j--) {
                    a[j + 1] = a[j]; // 将大于temp的值整体后移一个单位
                }
                a[j + 1] = temp;
            }
        }
    }

    /**
     * 折半插入排序。
     * 相对于直接插入减少了比较次数 
     * 时间复杂度还是O(n2)
     * @param a
     */
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
     * 希尔排序。
     * 又叫最小增量排序。
     * 比较和记录次数依赖增量的选择，所以是不稳定排序
     * @param a
     */
    public static void shellSoet(int[] a) {
        double d1 = a.length;
        int temp = 0;
        while (true) {
            //获得本趟增量
            d1 = Math.ceil(d1 / 2);
            int d = (int) d1;
            for (int x = 0; x < d; x++) {
                //针对每个分组排序
                for (int i = x + d; i < a.length; i += d) {
                    if(a[i]<a[i-d]){
                        int j = i - d;
                        temp = a[i];
                        for (; j >= 0 && temp < a[j]; j -= d) {
                            a[j + d] = a[j];//记录后移
                        }
                        //插入元素
                        a[j + d] = temp;
                    }
                }
            }
            if (d == 1) {
                break;
            }
        }
    }

    public static void printResult(int[] a) {
        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i]);
        }
    }
}
