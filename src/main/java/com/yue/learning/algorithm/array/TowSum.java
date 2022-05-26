package com.yue.learning.algorithm.array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TowSum {
	public static void main(String[] args) {
		int[] nums1 = {2,7,11,12,0};
		int target1 = 9;
		System.out.println(Arrays.toString(towSum(nums1,target1)));

		int[] nums2 = {3,2,4};
		int target2 = 6;
		System.out.println(Arrays.toString(towSum(nums2,target2)));

		int[] nums3 = {3,3};
		int target3 = 6;
		System.out.println(Arrays.toString(towSum(nums3,target3)));
	}

	private static int[] towSum(int[] arr, int target){
		Map<Integer,Integer> map = new HashMap<>();
		for (int i = 0; i < arr.length; i++) {
			if (map.get(target-arr[i])!=null){
				return new int[]{map.get(target-arr[i]),i};
			}else {
				map.put(arr[i],i);
			}
		}
		return null;
	}
}
