package com.tony.algorithms.huawei;

/*
输入整型数组求数组的最小数和最大数之和，例如输入1,2,3,4则输出为5，
当输入只有一个数的时候，则最小数和最大数都是该数，例如只输入1，则输出为2；
另外数组的长度不超过50
*/
public class Test12015 {
    public static void main(String[] args) {
        System.out.println(formatString(" "));
        System.out.println(formatString("   aaa   a     aa  "));
    }
    public static String formatString(String sourceString) {
        sourceString = sourceString.trim();
        StringBuffer sb = new StringBuffer();
        if(sourceString!=null){
            char[] cArray = sourceString.toCharArray();
            int i=0;
            while(i<cArray.length){
                if(cArray[i] != ' '){
                    sb = sb.append(cArray[i]);
                    i++;
                    sb = sb.append(cArray[i]);
                }
                i++;
            }
        }
        return sb.toString();
    }
}
