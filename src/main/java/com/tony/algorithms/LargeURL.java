package com.tony.algorithms;

import java.util.HashSet;

/**
 * @author Administrator
 * 一个大的含有50M个URL的记录，一个小的含有500个URL的记录，找出两个记录里相同的URL。
 */
public class LargeURL {
	/*
	 * 回答：首先使用包含500个url的文件创建一个hash_set。
	 * 然后遍历50M的url记录，如果url在hash_set中，则输出此url并从hash_set中删除这个url。
	 * 所有输出的url就是两个记录里相同的url。
	 */
	static String[] large = new String[] { "1111", "4444", "3333", "1111",
			"5555", "6666" };

	public static void main(String args[]) {
		HashSet<String> small = new HashSet<String>();
		small.add("1111");
		small.add("2222");
		small.add("3333");
		small.add("1111");
		for (String str : large) {
			if (small.contains(str)) {
				System.out.println(str);
				small.remove(str);
			}
		}

	}
}
