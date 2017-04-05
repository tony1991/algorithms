package com.tony.algorithms;

/**
 * 类NStep.java的实现描述：TODO 类实现描述 
 * @author tony 2015年9月8日 上午11:20:51
 * 输入数值N ，登台阶： 一次可以登一个台阶，也可以登两个台阶 ，登上N个台阶求总有多少种方法。
 */
public class NStep {
    static final int s      = 10;        // 自定义的台阶数
    static int       len    = 0, sum = 0;
    static int       step[] = new int[s];
    static void compute(final int stair) {
        if (stair < 0) return;
        if (stair == 0) {
            printSum();
            sum++;
            return;
        }
        for (int i = 1; i < 3; i++) {
            step[len] = i;
            len++;
            compute(stair - i);
            len--;
        }
    }

    static void printSum() {
        System.out.print("走法:");
        for (int i = 0; i < len; i++)
            System.out.print(step[i] + " ");
        System.out.println();
    }

    public static void main(String args[]) {
        compute(s);
        System.out.println("共有" + sum + "种走法");
    }
}
