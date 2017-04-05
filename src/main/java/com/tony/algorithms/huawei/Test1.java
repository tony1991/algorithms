package com.tony.algorithms.huawei;

import java.util.Scanner;

/*
 * 老师想知道从某某同学当中，分数最高的是多少，现在请你编程模拟老师的询问。
 * 当然，老师有时候需要更新某位同学的成绩. 
 * 输入例子: 5 7 
 * 1 2 3 4 5 
 * Q 1 5 
 * U 3 6 
 * Q 3 4 
 * Q 4 5 
 * U 4 5 
 * U 2 9 
 * Q 1 5 
 * 输出例子:对于每一次询问操作，在一行里面输出最高成绩. 5 6 5 9
 */
public class Test1 {

    public static void main(String[] args) {
        int M = 0, N = 0;// 输入
        int i;
        int A = 0, B = 0;
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            N = in.nextInt();
            M = in.nextInt();
            // 分数
            int[] score = new int[N];
            for (i = 0; in.hasNext() && i < N; i++) {
                score[i] = in.nextInt();
            }
            String c = null;
            for (i = 0; in.hasNext() && i < M; i++) {
                c = in.next();
                A = in.nextInt();
                B = in.nextInt();
                process(c, A, B, score);
            }
        }
    }

    private static void process(String c, int a, int b, int[] score) {
        int begin, end;
        if (c.equals("Q")) {
            end = Math.max(a, b);
            begin = Math.min(a, b) - 1;
            int max = score[begin];
            for (int i = begin; i < end; i++) {
                if (max < score[i]) {
                    max = score[i];
                }
            }
            System.out.println(max);
        } else if (c.equals("U")) {
            score[a - 1] = b;
        }
    }

}
