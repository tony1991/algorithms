package com.tony.algorithms;

/**
 * 类Find.java的实现描述：TODO 类实现描述 
 * @author tony 2015年8月29日 下午9:51:24
 * 0和任何数异或结果为该数本身，任何数与自己异或结果为零。
 */
public class Find3Times {

    public static int findTreetimes(int[] A) {
        int n = A.length;
        int result = 0;
        for (int i = 0; i < n; i++) {
            result ^= A[i];
        }
        return result;
    }

    public static void main(String[] args) {
        int[] A = { 88, 459, 5262, 88, -17, 677, 88, 677, -17, 459, 5262 };
        int result = findTreetimes(A);
        System.out.print("输出:" + result);
    }
}
