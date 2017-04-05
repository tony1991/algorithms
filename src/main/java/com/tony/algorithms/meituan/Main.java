package com.tony.algorithms.meituan;

public class Main {

    public static void main(String[] args) {
        int[][] a = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 }, { 13, 14, 15, 16 } };
        int[] array = getPrint(a,4);
        for(int i=0;i<array.length;i++){
            System.out.print(array[i]+" ");
        }
    }

    private static int[] getPrint(int[][] a,int n) {
        int[] result = new int[n*n];
        int s = 0;
        int size = a.length;
        int len = 2 * a.length - 1;// 一共生成几行结果
        for (int k = 0; k < len; k++) {
            // 规律是第 K的 列号-行号=size-1-k
            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size; j++) {
                    if (j - i == size - 1 - k) {
                        result[s] = a[i][j];
                        s++;
                    }
                }
            }
        }
        return result;
    }
}
