package com.tony.algorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Administrator 一串数据的最大递增序列，输出个数.例如 4，2， 6，3， 1，5，最大递增序列为， 2，3， 5，输出3
 */
public class MaxSubList {

	// 求数组中最长递增子序列
	public static void main(String[] args) {
		int a[] = { 1, -1, 2, -3, 4, -5, 6, -7 };
		String s = "ask not what your country can do for you,but what you can do for your country";
		find1(a);
		String postep = findString(s);
		System.out.println(postep);
	}

	// [1, -1, 2, -3, 4, -5, 6, -7]
	// [1, 1, 2, 1, 3, 1, 4, 1]
	// 时间复杂度:O(N*N)
	public static void find1(int[] a) {
		int length = a.length;
		int[] list = new int[length];// 存储第i个元素之前的最长递增序列值
		List<Integer> result = new ArrayList<Integer>(); // 存储最长递增序列
		for (int i = 0; i < length; i++) {
			list[i] = 1;
			for (int j = 0; j < i; j++) {
				if (a[j] < a[i] && list[j] + 1 > list[i]) {
					list[i] = list[j] + 1;
					if (result.isEmpty()) {
						result.add(list[j]);
					}
					if (!result.contains(list[i])) {
						result.add(list[i]);
					}
				}
			}
		}
		System.out.println("第i个元素时最长递增序列：" + Arrays.toString(list));
		// 寻找list中最大值
		int max = list[0];
		for (int i = 0; i < length; i++) {
			if (list[i] > max) {
				max = list[i];
			}
		}
		System.out.println("最长递增序列长度：" + max);
		System.out.println("最长递增序列：" + result);
	}

	// 这是我见到一个大神写的。给定一个字符串,求出其最长的重复子串。
	public static String findString(String str) {
		String tep, postep;
		postep = null;
		int len = 0;
		for (int i = 0; i < str.length(); i++) {
			for (int j = str.length() - 1; j > i; j--) {
				if (j + i < str.length()) {
					tep = str.substring(i, j);
					int front = str.indexOf(tep);// 从前往后找，找到的第一个字符所在整个字符串中的位置（从0开始的）
					int behind = str.lastIndexOf(tep);// 从后往前找。。。。。
					int teplen = tep.length();
					if (front != behind && teplen >= len) {
						len = teplen;
						postep = tep;
					}
				}

			}
		}

		return postep;
	}
	
}
