package com.yue.learning.algorithm.binarytree;

/**
 * 二分-练习二分查找法
 *
 */
public class BinarySearch {
	public static void main(String[] args) {
		//		问题1
		//		给定一个有序的数组，查找 value 是否在数组中，不存在返回 -1。
		//		例如：{ 1, 2, 3, 4, 5 } 找 3，返回下标 2（下标从 0 开始计算）。
		System.out.println(binarySearch(new int[]{1, 2, 3, 4, 5}, 5));
		//		问题2
		//		给定一个有序的数组，查找第一个等于 value 的下标，找不到返回 -1。（如果是最后一个呢）
		//		例如：{ 1, 2, 2, 2, 4 } 找 2，返回下标 1（下标从 0 开始计算）
		System.out.println(binarySearch2(new int[]{1, 2, 2, 2, 5}, 2));
		//		问题3
		//		给定一个有序的数组，查找第一个大于等于 value 的下标，都比 value 小则返回 -1。
		System.out.println(binarySearch3(new int[]{1, 2, 2, 2, 5}, 3));
	}



	private static int binarySearch(int[] arr, int target) {
		int left = 0;
		int right = arr.length - 1;
		while (left <= right) {
			int mid = (left + right) >> 1;
			if (arr[mid] > target) {
				right = mid - 1;
			} else if (arr[mid] < target) {
				left = mid + 1;
			} else {
				return mid;
			}
		}
		return -1;
	}

	private static int binarySearch2(int[] arr, int target) {
		int left = 0;
		int right = arr.length - 1;
		while (left <= right) {
			int mid = (left + right) >> 1;
			if (arr[mid] >= target) {
				right = mid - 1;
			} else {
				left = mid + 1;
			}
		}
		if (left < arr.length && arr[left] == target) {
			return left;
		}
		return -1;
	}

	private static int binarySearch3(int[] arr, int target) {
		int left = 0;
		int right = arr.length - 1;
		while (left <= right) {
			int mid = (left + right) >> 1;
			if (arr[mid] >= target) {
				right = mid - 1;
			} else {
				left = mid + 1;
			}
		}
		if (left < arr.length && arr[left] == target) {
			return left;
		}
		return -1;
	}
}
