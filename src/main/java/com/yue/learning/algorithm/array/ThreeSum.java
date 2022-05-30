package com.yue.learning.algorithm.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给你一个包含 n 个整数的数组nums，判断nums中是否存在三个元素 a，b，c ，使得a + b + c = 0 ？请你找出所有和为 0 且不重复的三元组。
 * <p>
 * 注意：答案中不可以包含重复的三元组。
 * <p>
 * 示例 1：
 * 输入：nums = [-1,0,1,2,-1,-4]
 * 输出：[[-1,-1,2],[-1,0,1]
 * <p>
 * 示例 2：
 * 输入：nums = []
 * 输出：[]
 * <p>
 * 示例 3：
 * 输入：nums = [0]
 * 输出：[]
 * <p>
 * 提示：
 * 0 <= nums.length <= 3000
 * -105 <= nums[i] <= 105
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/3sum
 */
public class ThreeSum {
	public static void main(String[] args) {
		System.out.println(threeSum(new int[]{-1,0,1,2,-1,-4}));
		System.out.println(threeSum(new int[]{}));
		System.out.println(threeSum(new int[]{0}));
	}

	private static List<List<Integer>> threeSum(int[] nums) {
		//排序
		Arrays.sort(nums);
		List<List<Integer>> result = new ArrayList<>();

		// 双指针法
		for (int i = 0; i < nums.length; i++) {
			if (nums[i]>0||(i>0&&nums[i]==nums[i-1])){
				break;
			}
			int l = i+1;
			int r =  nums.length-1;
			// 先确定一个基准点，然后通过双指针移动，寻找符合条件的值
			while (l<r){
				int sum = nums[i] + nums[l] + nums[r];
				if (sum<0)
					l++;
				else if (sum>0)
					r--;
				else{
					List<Integer> list = new ArrayList<>();
					list.add(nums[i]);
					list.add(nums[l]);
					list.add(nums[r]);
					result.add(list);
					l++;
					r--;
				}
			}
		}

		return result;
	}
}
