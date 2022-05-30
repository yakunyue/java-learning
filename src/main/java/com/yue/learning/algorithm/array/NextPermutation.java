package com.yue.learning.algorithm.array;

import java.util.Arrays;

/**
 * 整数数组的一个 排列 就是将其所有成员以序列或线性顺序排列。
 * <p>
 * 例如，arr = [1,2,3] ，以下这些都可以视作 arr 的排列：[1,2,3]、[1,3,2]、[3,1,2]、[2,3,1] 。
 * 整数数组的 下一个排列 是指其整数的下一个字典序更大的排列。更正式地，如果数组的所有排列根据其字典顺序从小到大排列在一个容器中，那么数组的 下一个排列 就是在这个有序容器中排在它后面的那个排列。如果不存在下一个更大的排列，那么这个数组必须重排为字典序最小的排列（即，其元素按升序排列）。
 * <p>
 * 例如，arr = [1,2,3] 的下一个排列是 [1,3,2] 。
 * 类似地，arr = [2,3,1] 的下一个排列是 [3,1,2] 。
 * 而 arr = [3,2,1] 的下一个排列是 [1,2,3] ，因为 [3,2,1] 不存在一个字典序更大的排列。
 * 给你一个整数数组 nums ，找出 nums 的下一个排列。
 * <p>
 * 必须 原地 修改，只允许使用额外常数空间。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/next-permutation
 */
public class NextPermutation {
	public static void main(String[] args) {
		System.out.println(Arrays.toString(next(new int[]{1, 2, 3})));
		System.out.println(Arrays.toString(next(new int[]{2, 3, 1})));
		System.out.println(Arrays.toString(next(new int[]{3, 2, 1})));
		System.out.println(Arrays.toString(next(new int[]{1, 2})));
		System.out.println(Arrays.toString(next(new int[]{2, 1})));
		System.out.println(Arrays.toString(next(new int[]{2})));
	}

	private static int[] next(int[] nums) {
		int i = nums.length - 2;
		//从后往前，找到第一个出现降序的位置
		while (i >= 0 && nums[i] >= nums[i + 1]) {
			i--;
		}
		if (i == -1) {
			Arrays.sort(nums);
			return nums;
		}
		// 找到arr[i]之后，第一个比arr[i]小的数字，取这个数的前一个数字，和i交换位置。
		int j = i + 1;
		while (j < nums.length && nums[j] > nums[i])
			j++;

		// 交换j-1和i
		swap(nums, i, j - 1);
		//将i之后的数字倒排
		int l = i + 1;
		int r = nums.length-1;
		while (l < r){
			swap(nums, l, r);
			l++;
			r--;
		}

		return nums;
	}

	private static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
}
