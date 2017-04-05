package com.tony.algorithms.sort;

/**
 * 类SwapSort.java的实现描述：TODO 类实现描述
 * 
 * @author tony 2015年9月4日 上午10:43:38 交换排序分为冒泡排序、快速排序
 */
public class SwapSort {

    public static void main(String[] args) {
        int[] a = { 49, 38, 65, 97, 76, 13, 27, 49, 78, 34, 12, 64, 5, 4, 62, 99, 98, 54, 56, 17, 18, 23, 34, 15, 35,
                25, 53, 51 };
//        bubbleSort(a);
        quickSort(a);
        printResult(a);
    }

    /**
     * 冒泡排序。 相邻两个两两比较。每次都从头开始。
     * @param a
     */
    public static void bubbleSort(int[] a) {
        int temp = 0;
        for (int i = a.length - 1; i >0 ; i--) {
            int swap = 0;// 是否交换的标志。如果在某一趟中没有发生交换，表明已经有序，不需要再比较，排序提前结束。
            // 注意这里循环条件需要-i，即后面排好序的不需要比较。
            for (int j = 0; j < i; j++) {
                if (a[j] > a[j + 1]) {
                    temp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = temp;
                    swap = 1;
                }
            }
            if (swap == 0) break;
        }
    }

    /**
     * 快速排序。
     * @param a
     */
    public static void quickSort(int[] a) {
        if (a.length > 0) { // 查看数组是否为空
            quickSort(a, 0, a.length - 1);
        }
    }

    /**
     * 迭代。
     * @param list
     * @param low
     * @param high
     */
    public static void quickSort(int[] list, int low, int high) {
        if (low < high) {                           //list长度大于1
            int middle = getMiddle(list, low, high); // 将list数组进行一分为二
            quickSort(list, low, middle - 1); // 对低字表进行递归排序
            quickSort(list, middle + 1, high); // 对高字表进行递归排序
        }
    }

    /**
     * 此方法为快排的核心，即划分。
     * @param list
     * @param low
     * @param high
     * @return
     */
    public static int getMiddle(int[] list, int low, int high) {
        int tmp = list[low]; // 数组的第一个作为中轴
        //从表的两端交替向中间扫描
        while (low < high) {
            while (low < high && list[high] >= tmp) {
                high--;
            }
            list[low] = list[high]; // 比中轴小的记录移到低端
            while (low < high && list[low] <= tmp) {
                low++;
            }
            list[high] = list[low]; // 比中轴大的记录移到高端
        }
        list[low] = tmp; // 中轴记录到位
        return low; // 返回中轴的位置
    }

    public static void printResult(int[] a) {
        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i]);
        }
    }
}
