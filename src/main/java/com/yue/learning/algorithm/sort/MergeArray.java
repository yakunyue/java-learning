package com.yue.learning.algorithm.sort;

/**
 * 数组、双指针
 *
 * 合并两个有序数组
 * 给出一个整数数组 和有序的整数数组 ，请将数组 合并到数组 中，变成一个有序的升序数组
 * 注意：
 * 1.可以假设 数组有足够的空间存放 数组的元素， 和 中初始的元素数目分别为 和 ，的数组空间大小为 +
 * 2.不要返回合并的数组，返回是空的，将数组 的数据合并到里面就好了
 * 3.数组在[0,m-1]的范围也是有序的
 * <p>
 * 例1:
 * A: [1,2,3,0,0,0]，m=3
 * B: [2,5,6]，n=3
 * 合并过后A为:
 * A: [1,2,2,3,5,6]
 */
public class MergeArray {
	public static void main(String[] args) {
		int[] a = {1, 2, 3, 0, 0, 0};
		int[] b = {2, 5, 6};
		merge(a, 3, b, 3);
		System.out.println(a);
	}

	private static void merge(int[] a, int m, int[] b, int n) {
		for (int i = m + n - 1; m > 0 && n > 0; i--) {
			if (a[m - 1] > b[n - 1]) {
				a[i] = a[m - 1];
				m--;
			} else {
				a[i] = b[n - 1];
				n--;
			}
		}

		while (n >= 0) {
			a[n] = b[n--];
		}
	}
}
