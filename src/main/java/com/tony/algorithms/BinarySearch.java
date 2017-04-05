package com.tony.algorithms;

/**
 * 类BinarySearch.java的实现描述：TODO 类实现描述 
 * @author tony 2015年9月10日 下午3:52:58
 * 给定一个整数数组A及它的大小n，同时给定要查找的元素val，请返回它在数组中的位置(从0开始)，若不存在该元素，返回-1。
 * 若该元素出现多次，请返回第一次出现的位置。
测试样例：
[1,3,5,7,9],5,3
返回
1
 */
public class BinarySearch {
    public static void main(String[] args) {
        int[] A = {1,2,3,5,7,9};
        int index = getPos(A,6,3);
        System.out.println(index);
    }
    
    public static int getPos(int[] A, int n, int val) {
        int low = 0;
        int high = n;
        int mid;
        while(low<=high){
            mid = (low+high)/2;
            if(val == A[mid]){
                //若该元素出现多次，请返回第一次出现的位置
                while(mid>=0 && val == A[mid]){
                    mid--;
                }
                return ++mid;
            }else if(val < A[mid]){//在左边找
                high = mid - 1;
            }else{
                low = mid + 1;
            }
        }
        return -1;//找不到返回-1
    }
}
