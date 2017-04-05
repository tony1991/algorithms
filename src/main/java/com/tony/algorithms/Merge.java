package com.tony.algorithms;

import java.util.Scanner;

/**
 * @author Administrator
 *         http://www.cnblogs.com/e241138/archive/2012/10/19/2731811.html 给定数组
 *         求其逆序对的个数 如给定{5,8,3,1} 则有<5,3><5,1><8,3><8,1><3,1> 5个逆序对
 */
public class Merge {
	private static int count = 0;

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		// System.out.println(n);
		int[] array = new int[n];
		for (int i = 0; i < n; i++) {
			array[i] = in.nextInt();
		}
		System.out.println(commonFunc(array, n)); // 普通遍历排序
		
		mergeSort(array, 0, n-1);
		System.out.println(count); // 归并排序
	}

	/**
	 * 普通方法
	 * 
	 * @param array
	 * @param n
	 * @return
	 */
	public static int commonFunc(int[] array, int n) {
		int pair = 0;
		for (int p = 0; p < n - 1; p++) {
			for (int q = p + 1; q < n; q++) {
				if (array[p] > array[q]) {
					pair++;
				}
			}
		}
		return pair;
	}

	// merge_sort
	public static void mergeSort(int[] array, int left, int right) {
		int middle;
		if (left >= right) {
			return;
		}
		middle = (int) (left + right) / 2;
		mergeSort(array, left, middle);// 左半部分递归调用
		mergeSort(array, middle + 1, right);// 右半部分递归调用
		merge(array, left, middle, right);// 归并
	}

	public static void merge(int[] array, int left, int middle, int right) {
		int[] tmpArr = new int[right + 1];
		
		int mid = middle + 1;
		int index = left; // index记录临时数组的索引
		int tmp = left;

		// 从两个数组中取出最小的放入临时数组中
		while (left <= middle && mid <= right) {
			if (array[left] <= array[mid]) {
				tmpArr[index++] = array[left++];
			} else {
				tmpArr[index++] = array[mid++];
				count = count + mid - index;
			}
		}
		// 剩余部分依次放入临时数组
		while (mid <= right) {
			tmpArr[index++] = array[mid++];
		}
		while (left <= middle) {
			tmpArr[index++] = array[left++];
		}
		
		// 打印归并后数组  将临时数组中的内容复制回原数组
		for (int i = tmp; i <= right; i++) {
			array[i] = tmpArr[i];
		}
//		System.out.println(Arrays.toString(array));
	}
}