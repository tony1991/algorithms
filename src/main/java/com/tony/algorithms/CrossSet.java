package com.tony.algorithms;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

/**
 * @author Administrator
 *  蘑菇街笔试题：求两个整型数据集合的交集。
 *  初步想法是用hash。也可以用布隆过滤器。
 * 	比如说A集合有元素M个，B集合有元素N个。我们初始化一个max（M,N）的数组，然后hash算法算出其hash值，hash值再对max（M,N）求余数。
 * 	这样就可以插入到数组中去（用求余后的hash值作为下标），我们也可以用2倍max（M,N）作为数组长度，这样就可以尽可能的避免冲突。
 * 	当我们插入完A集合的元素后，我们就开始算B集合的元素，如此一来，对每一个B集合的元素都算一次，确定hash值，求余，比对。
 * 	那么整个过程在时间复杂度最好的情况下，也就是计算M+N次hash值，最多比对M+N次数(发生冲突的情况下，最好的情况就是没有冲突，一算一个准)。即可选出交集。
 * 	那么如果不使用上述算法，那么使用最简单的方法，就是比对M*N次。
 */
public class CrossSet {
	public static int setSize = 1000000;
	public static int hashSize = setSize * 2;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Integer A[] = new Integer[setSize];
		Integer B[] = new Integer[setSize];
		for (int i = 0; i < setSize; i++) {
			A[i] = (new Random().nextInt(setSize * 10));
			B[i] = (new Random().nextInt(setSize * 10));
		}
		System.out.println("赋值完毕");
		long beginTime = System.currentTimeMillis();
		Integer hashtable[] = new Integer[hashSize];
		// 现在将将A集合的数都放到hash表中，以数的hash值为下标，使用开放寻址法来解决冲突
		// 其实用拉链法更好
		for (int i = 0; i < setSize; i++) {
			// 取到需要存的数的下标
			int index = A[i].toString().hashCode() % hashSize;
			if (index < 0) {
				index *= -1;
			}
			while (hashtable[index] != null) {
				if (index >= hashSize - 1) {
					index = 0;
				} else {
					index++;
				}
			}
			hashtable[index] = A[i];
		}
		List<Integer> result = new LinkedList<Integer>();
		// 开始对B
		for (int i = 0; i < setSize; i++) {
			// 取到需要存的数的下标
			int index = B[i].toString().hashCode() % hashSize;
			if (index < 0) {
				index *= -1;
			}
			while (hashtable[index] != null) {
				if (hashtable[index] == B[i]) {
					result.add(B[i]);
					break;
				}
				if (index >= hashSize - 1) {
					index = 0;
				} else {
					index++;
				}

			}
		}
		if (result.size() != 0) {
			for (int i = 0; i < result.size(); i++) {
				System.out.println(result.get(i));
			}
		} else {
			System.out.println("没有相同元素");
		}
		System.out.println("计算耗时：" + (System.currentTimeMillis() - beginTime)
				+ " 毫秒");
	}
}
