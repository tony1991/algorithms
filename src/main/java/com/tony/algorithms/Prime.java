package com.tony.algorithms;

public class Prime {
	public static void main(String[] args) {
		getPrime(100);
		sushu(1,100);
	}

	public static void getPrime(int n) {
		for (int i = 2; i < n; i++) {
			int j = 2;
			while (j < i) {
				if (i % j == 0) {
					break;
				} else {
					j++;
				}
			}
			if (j == i) {
				System.out.println(j + "");
			}
		}
	}

	public static void sushu(int n, int m) {
		for (int i = n; i < m; i++) {
			int temp = (int) Math.sqrt(i);
			if (i <= 3  && i!=1) {//注意1不是质数
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
}
