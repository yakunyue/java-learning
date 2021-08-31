package com.yue.learning.algorithm.binarytree.traversing;

import com.yue.learning.algorithm.binarytree.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 二叉树-二叉树的中序遍历
 */
public class BinaryTraversing_Inorder {
	public static void main(String[] args) {
		TreeNode root = new TreeNode(3);
		root.left = new TreeNode(9);
		root.right = new TreeNode(20);
		root.right.left = new TreeNode(8);
		root.right.right = new TreeNode(18);
		List<Integer> res = new ArrayList<>();
		traversing(root,res);
		res.forEach(System.out::println);
	}

	private static void traversing(TreeNode root,List<Integer> res){
		if (root == null){
			return;
		}
		traversing(root.left,res);
		res.add(root.value);
		traversing(root.right,res);
	}
}
