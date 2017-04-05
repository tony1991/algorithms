package com.tony.algorithms.sort;

public class MyTest {
    public static void main(String[] args) {
        int[] a = { 1,2,88,75,45,99,75};
        quickSort(a);
        printResult(a);
    }
    
    public static void quickSort(int[] a) {
        if(a.length>0){
            quickSort(a,0,a.length-1);
        }
    }

    private static void quickSort(int[] a, int low, int high) {
    }


    private static int getMiddle(int[] a, int low, int high) {
        return 0;
    }

    public static void printResult(int[] a) {
        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i]);
        }
    }
}
