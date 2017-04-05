package com.tony.algorithms.huawei;

import java.util.Scanner;

/**
 * 类Test3.java的实现描述：TODO 类实现描述
 * 
 * @author tony 2015年9月11日 下午2:18:21 计算字符串最后一个单词的长度，单词以空格隔开。
 */
public class Main {

    public static void main(String[] args) {
        Scanner scStr = new Scanner(System.in);
        String nStr = scStr.nextLine();
        // int n = Integer.valueOf(nStr);
//        String str = scStr.nextLine();
        // System.out.println(n + " " + str);
        // System.out.println(process1(str));
        // System.out.println(process2(str));
        // System.out.println(process3(n, str));
        // reverseWordTwo(nStr);
//        String result = getMaxString(nStr, str);
//        System.out.println(result);
        getUpWord(nStr);
    }

    private static void getUpWord(String s){
        if (s.isEmpty()) {
            System.out.println(0);
        } else {
            int no = 0;
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) >= 65 && s.charAt(i) <= 90) {
                    no++;
                }
            }
            System.out.println(no);
        }
    }
    private static String getMaxString(String str1, String str2) {
        String max = null;
        String min = null;
        max = (str1.length() > str2.length() ? str1 : str2);
        min = max.equals(str1) ? str2 : str1;
        for (int i = 0; i < min.length(); i++) {
            int start = 0;
            int end = min.length() - i;
            while (end != min.length() + 1) {
                String sub = min.substring(start, end);
                if (max.contains(sub)) return sub;
                start++;
                end++;
            }
        }
        return null;
    }

    public static void reverseWordTwo(String word) {
        for (int i = word.length(); i > 0; i--) {
            System.out.print(word.charAt(i - 1));
        }
    }

    /**
     * 合唱算法
     * 
     * @param n
     * @param str
     * @return
     */
    private static int process3(int n, String str) {
        int[] left = new int[n];
        int[] right = new int[n];
        for (int i = 0; i < n; i++) {
            left[i] = 1;
            for (int j = 0; j < i; j++) {
                if (str.charAt(j) < str.charAt(i) && left[j] > left[i] - 1) // 找出左边最长递增子序列
                left[i] = left[j] + 1;
            }
        }
        for (int i = n - 1; i >= 0; i--) {
            right[i] = 1;
            for (int j = n - 1; j > i; j--) {
                if (str.charAt(j) < str.charAt(i) && right[j] > right[i] - 1) // 找出右边最长递减子序列
                right[i] = right[j] + 1;
            }
        }
        int max = 0;
        for (int i = 0; i < n; i++) {
            if (max < left[i] + right[i] - 2) max = left[i] + right[i] - 2; // 寻找最多合唱人数
        }
        return max;
    }

    /**
     * 图片排序
     * 
     * @param str
     * @return
     */
    private static String process2(String str) {
        char[] charArray = str.toCharArray();
        char temp;
        for (int i = charArray.length - 1; i > 0; i--) {
            int swap = 0;
            for (int j = 0; j < i; j++) {
                if (charArray[j] > charArray[j + 1]) {
                    temp = charArray[j];
                    charArray[j] = charArray[j + 1];
                    charArray[j + 1] = temp;
                    swap = 1;
                }
            }
            if (swap == 0) break;
        }
        return new String(charArray);
    }

    private static int process1(String str) {
        String[] split = str.trim().split(" ");
        int length = split[split.length - 1].length();
        return length;
    }

}
