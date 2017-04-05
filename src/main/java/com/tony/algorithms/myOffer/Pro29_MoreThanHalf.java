package com.tony.algorithms.myOffer;

/**
 * 类Problem29_MoreThanHalf.java的实现描述：TODO 类实现描述 
 * @author tony 2015年9月9日 下午3:08:55
 * 寻找水贴王。
 * 如果每次删除两个不同的ID，那么剩下的ID列表中，“水王”ID出现的次数仍然超过总数的一半。看到 
 * 这一点后，就可以通过不断重复这个过程，把ID列表中的ID总数降低(转化为更小的问题)，从而得到 
 * 问题的答案 
 */
public class Pro29_MoreThanHalf {

    public static void main(String[] args) {
        int[] array = { 1, 2, 5, 7, 8, 1, 1, 1, 1, 4, 1 };
        System.out.println(find(array, array.length));
    }

    private static int find(int[] array, int n) {
        int candidate = 0; // 要找的id
        int nTimes = 0; // 要找的id出现的次数
        for (int i = 0; i < n; i++) {
            if (nTimes == 0) { // 如果次数变为0，则重新指定candidate
                candidate = array[i];
                nTimes = 1;
            } else {
                if (candidate == array[i]) { // 如果candidate和array[i]的值相等，那么candidate出现的次数可以加1
                    nTimes++;
                } else {
                    nTimes--; // 如果不相等，那么candidate出现的次数减1
                }
            }
        }
        return candidate;
    }
}
