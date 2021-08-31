package com.yue.learning.algorithm.binarytree.traversing;

import com.yue.learning.algorithm.binarytree.TreeNode;

public class PathSum {

	public static void main(String[] args) {
		TreeNode root = new TreeNode(5);
		root.left = new TreeNode(4);
		root.right = new TreeNode(8);
		root.left.left = new TreeNode(11);
		root.left.left.left = new TreeNode(7);
		root.left.left.right = new TreeNode(2);
		root.right.left = new TreeNode(13);
		root.right.right = new TreeNode(4);
		root.right.right.right = new TreeNode(1);

		System.out.println(traverse(root, 0, 22));
	}

	private static boolean traverse(TreeNode root,int sum, int value){
		if (root==null){
			return sum==value;
		}
		sum += root.value;
		boolean r1 = traverse(root.left, sum, value);
		boolean r2 = false;
		if (!r1){
			r2 = traverse(root.right, sum, value);
		}
		sum -= root.value;
		return r1||r2;
	}
}
