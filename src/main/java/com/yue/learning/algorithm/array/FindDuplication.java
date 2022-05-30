package com.yue.learning.algorithm.array;

import java.util.Arrays;

/**
 * 给定一个包含n + 1 个整数的数组nums ，其数字都在[1, n]范围内（包括 1 和 n），可知至少存在一个重复的整数。
 * <p>
 * 假设 nums 只有 一个重复的整数 ，返回这个重复的数 。
 * <p>
 * 你设计的解决方案必须 不修改 数组 nums 且只用常量级 O(1) 的额外空间。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/find-the-duplicate-number
 */
public class FindDuplication {
	public static void main(String[] args) {

	}

	//排序法
	public static int find1(int[] nums) {
		Arrays.sort(nums);
		int i = 0;
		while (i < nums.length && nums[i] != nums[i + 1])
			i++;
		return nums[i];
	}

	//快慢指针
	public static int find2(int[] nums) {
		int fast = 0;
		int slow = 0;
		do {
			fast = nums[nums[fast]];
			slow = nums[slow];
		} while (nums[fast] != nums[slow]);

		int i = 0;

		while (nums[i] != nums[slow]) {
			i = nums[i];
			slow = nums[slow];
		}
		return nums[i];
	}

	//二分查找
	public static int find3(int[] nums) {
		int l = 1;
		int r = nums.length - 1;

		while (l <= r) {
			int i = (l+r) / 2;
			int count = 0;
			for (int num : nums) {
				if (num <=i){
					count++;
				}
			}
			if (count<=i){
				l=i+1;
			}else {
				r=i;
			}
		}
		return r;
	}
}
