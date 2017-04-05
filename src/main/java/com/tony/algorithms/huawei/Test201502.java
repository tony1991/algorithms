package com.tony.algorithms.huawei;

public class Test201502 {

    public static void main(String[] args) {
        String str = "aabcdefff";
        System.out.println(process(str));
    }

    private static String process(String str) {
        //存储排序好的字符
        char[] sortArray = new char[str.length()];
        char[] cArray = str.toCharArray();
        for (int i = 0; i < cArray.length; i++) {
            for(int j=0;j<sortArray.length;j++){
                //如果原数组里的字符小于排序后数组里的字符，则排序后的数组里的字符向后移动一位
                if(cArray[i]<sortArray[j]){
                    char temp = sortArray[i];
                    int k = j - 1;
                    for (; j >= 0 && temp < sortArray[k]; k--) {
                        sortArray[k + 1] = sortArray[k]; // 将大于temp的值整体后移一个单位
                    }
                    sortArray[k + 1] = temp;
                }
            }
        }
        return null;
    }
}
