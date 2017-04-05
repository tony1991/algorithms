package com.tony.algorithms.king;

import java.util.Scanner;

public class Main2 {

    public static void main(String[] args) {
        System.out.println(5%1000000007);
        int n,m,k,i;
        int[][] array = new int[50][50];
        Scanner in = new Scanner(System.in);
        int start = 0, end = 0;
        while (in.hasNext()) {
            n = in.nextInt();
            m = in.nextInt();
            k = in.nextInt();
            for (i = 0; i < n; i++) {
                for(int j =0;j<m;j++){
                    int num = in.nextInt();
                    array[i][j]=num;
                }
            }
        }
        System.out.println(5);
    }
}
