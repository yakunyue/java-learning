package com.yue.learning.algorithm.array;

/**
 * 编写一个高效的算法来判断m x n矩阵中，是否存在一个目标值。该矩阵具有如下特性：
 * <p>
 * 每行中的整数从左到右按升序排列。
 * 每行的第一个整数大于前一行的最后一个整数。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/search-a-2d-matrix
 */
public class SearchMatrix {
	public static void main(String[] args) {

	}

	private static boolean searchMatrix(int[][] matrix, int target) {
		int m = matrix.length;
		int n = matrix[0].length;
		if (m <= 0 || n <= 0) {
			return false;
		}
		int total = m * n;
		int l = 0;
		int r = total - 1;
		while (l <= r) {
			int i = (l + r) / 2;
			int e = matrix[i / n][i % n];
			if (e < target)
				l = i + 1;
			else if (e > target)
				r = i - 1;
			else
				return true;
		}

		return false;
	}
}
