package com.tony.algorithms.sougo.test2;

import java.util.*;

public class Main {
//12312 3 1 2 3
    static void shuffle(int a[], int seed) {
        int n = a.length;
        Random rand = new Random(seed);//同一随机种子产生一个确定的随机序列
        for (; n > 1; n--) {
            int r = rand.nextInt(n);//1,1
            int tmp = a[n - 1];
            a[n - 1] = a[r];
            a[r] = tmp;
        }
    }

    static void restore(int a[], int seed) {
        /* 填写代码 */
        int n = a.length;
        Random rand = new Random(seed);//同一随机种子产生一个确定的随机序列
        for (; n > 1; n--) {
            int r = rand.nextInt(n);
            int tmp = a[n - 1];
            a[n - 1] = a[r];
            a[r] = tmp;
        }
    }

    public static void main(String[] args) {
        int seed, n, i;
        int[] a, b;
        Scanner input = new Scanner(System.in);
        {
            seed = input.nextInt();
            n = input.nextInt();
            a = new int[n];
            for (i = 0; i < n; ++i)
                a[i] = input.nextInt();
        }
        b = Arrays.copyOf(a, a.length);
        shuffle(a, seed);
        restore(a, seed);
        for (i = 0; i < n; i++) {
            if (a[i] != b[i])
                break;
        }
        if (i == n)
            System.out.printf("Success!\n");
        else
            System.out.printf("Failed!\n");
    }
}
