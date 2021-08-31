package com.yue.learning.algorithm.sort;

import java.time.LocalDateTime;
import java.util.Arrays;

/**
 * 快速排序
 */
public class QuickSort {
	public static void main(String[] args) {
		int[] arr = {4,1,2,4,7,3,4,7,9,5,0,8,6};
		System.out.println(Arrays.toString(arr));
		sort(arr,0,arr.length-1);
		System.out.println(Arrays.toString(arr));
	}

	public static void sort(int[] arr,int left,int right){
		if (left<right){
			int index = partSort(arr, left, right);
			sort(arr,left,index-1);
			sort(arr,index+1,right);
		}
	}

	private static int partSort(int[] arr, int left, int right) {
		int pivot = left;
		int index = left +1;
		for (int i = index; i <= right; i++) {
			if (arr[i]< arr[pivot]){
				swap(arr, i, index);
				index++;
			}
		}
		swap(arr, pivot, index-1);
		return index-1;
	}

	private static void swap(int[] arr, int index, int i) {
		int temp = arr[i];
		arr[i] = arr[index];
		arr[index] = temp;
	}

	public static Boolean isSameDay(LocalDateTime a,LocalDateTime b){
		return a.toLocalDate().equals(b.toLocalDate());
	}
}
