package com.tony.algorithms.search;

/**
 * 类HalfSearch.java的实现描述：TODO 类实现描述 
 * @author tony 2015年9月5日 上午10:04:35
 * 二分查找。
 */
public class HalfSearch {
    public static void main(String[] args) {
        int[] a = { 4,5,12,13,13,15,17,18,23,25,27,34,35,45,56,67,73,84,99};
        int index = halfSearch(a,13);
        System.out.println(index);
    }

    private static int halfSearch(int[] a, int key) {
        int high = a.length-1;
        int low = 0;
        int mid;
        while(low<=high){
            mid = (low+high)/2;
            if(key == a[mid]){
                /*  返回最后一个元素的下标，可以不要这个if */
                if (mid < high && a[mid] == a[mid + 1]) {
                    low = mid + 1;
                } else {
                    return mid;
                }
                //return mid;
            }else if(key < a[mid]){
                high = mid - 1;
            }else{
                low = mid + 1;
            }
        }
        return 0;
    }
}
