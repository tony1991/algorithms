package com.tony.algorithms;

import java.util.HashSet;
import java.util.Set;

public class SomeSimpleAlgorithms {

    public static void main(String[] args) {
        countRabit(24);
        getMaxAndMin(38, 64);
        getDayInYear(2015, 9, 1);
        getNineNine();
    }

    /**
     * 题：有一对兔子，从出生后第3个月起每个月都生一对兔子，小兔子长到第三个月后每个月又生一对兔子， 
     * 假如兔子都不死，问每个月的兔子总数为多少？ 
     * 解：斐波那契
     */
    public static void countRabit(int m) {
        System.out.println("第1个月的兔子对数: 1");
        System.out.println("第2个月的兔子对数: 1");
        int f1 = 1, f2 = 1, f;
        for (int i = 3; i <= m; i++) {
            f = f2;
            f2 = f1 + f2;
            f1 = f;
            System.out.println("第" + i + "个月的兔子对数: " + f2);
        }
    }

    /**
     * 求n-m之间的素数
     * 
     * @param n
     * @param m
     */
    public static void getPrime(int n, int m) {
        for (int i = n; i < m; i++) {
            int temp = (int) Math.sqrt(i);
            if (i <= 3 && i != 1) {// 注意1不是质数
                System.out.println(i);
            }
            for (int j = 2; j <= temp; j++) {
                if (i % j == 0) {
                    break;
                }
                if (j >= temp) {
                    System.out.println(i);
                }
            }
        }
    }

    /**
     * 求m和n的最大公约数和最小公倍数
     * 
     * @param m
     * @param n
     */
    public static void getMaxAndMin(int m, int n) {
        int max = getMaxCommon(m, n);
        int min = minCommonMultiple(m, n);
        System.out.println("最大公约数：" + max);
        System.out.println("最小公倍数：" + min);
    }

    // 最大公约数。运用递归调用将求余之后的值作为min,将之前的min作为max.直到求余值为0为止结束循环
    public static int getMaxCommon(int m, int n) {
        if (m < n) {// 保证m>n,若m<n,则进行数据交换
            int temp = m;
            m = n;
            n = temp;
        }
        while (m % n != 0) {// 在余数不能为0时,进行循环
            int temp = m % n;
            m = n;
            n = temp;
        }
        return n;// 返回最大公约数
    }

    // 最小公倍数
    public static int minCommonMultiple(int m, int n) {
        return m * n / getMaxCommon(m, n);
    }

    /**
     * 输入某年某月某日，判断这一天是这一年的第几天
     * 
     * @param y
     * @param m
     * @param d
     */
    public static void getDayInYear(int y, int m, int d) {
        int[] mDaysArray = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
        if ((y % 4 == 0 && y % 100 != 0) || y % 400 == 0) {
            mDaysArray[1] = 29;
        }
        int dayNum = 0;
        for (int i = 0; i < m; i++) {
            dayNum += mDaysArray[i];
        }
        System.out.println(y + "年" + m + "月" + d + "号是这一年的第" + dayNum + "天");
    }

    /**
     * 打印九九乘法表
     */
    public static void getNineNine() {
        for (int i = 1; i < 10; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(j + "*" + i + "=" + j * i + "    ");
                //保证对齐
                if (j * i < 10) {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }

    /**
     * 输出字符串中的所有重复子串：
     * 例如：abcab
     * 输出: a, b, ab
     *
     * @param s
     */
    private static void subStr(String s) {
        Set<String> stringSet = new HashSet<String>();
        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 1; j <= s.length(); j++) {
                String tstr = s.substring(i, j);
                if (stringSet.contains(tstr)) {
                    System.out.print(tstr + " ");
                }
                stringSet.add(tstr);
            }
        }
    }
}
