package com.tony.algorithms.meituan;

public class Main2 {

    public static void main(String[] args) {
        int count = 0;
        int sum = 0;
        int[] a = { 1, 2, 5, 10, 20, 50 };
        for (int i = 0; i < 100; i++) {
            for (int j = 0; j < 50; j++) {
                for (int k = 0; k < 20; k++) {
                    for (int l = 0; l < 10; l++) {
                        for (int m = 0; m < 5; m++) {
                            for (int n = 0; n < 2; n++) {
                                sum = i * a[0] + j * a[1] + k * a[2] + l * a[3] + m * a[4] + n * a[5];
                                if (sum == 100) {
                                    count++;
                                    System.out.println(i + "张1元," + j + "张2元," + k + "张5元," + l + "张10元," + m + "张20元,"
                                                       + n + "张50元" + "可以组成100元");
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}
