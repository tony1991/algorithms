package com.tony.algorithms.baidu;

import java.util.HashSet;
import java.util.Set;

public class KMP {

    public static void main(String[] args) {
        String s = "abcab";
        subStr(s);
    }

    /**
     * 输出字符串中的所有重复子串：
     * 例如：abcab
     * 输出: a, b, ab
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
