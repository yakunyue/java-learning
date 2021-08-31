package com.yue.learning.algorithm.binarytree.traversing;

import com.yue.learning.algorithm.binarytree.TreeNode;

import java.util.*;

/**
 * 二叉树、回溯-使用回溯法进行二叉树层遍历
 * <p>
 * 二叉树层遍历
 * 给定一个二叉树，返回该二叉树层序遍历的结果，（从左到右，一层一层地遍历,一层放进一个列表，最终返回一个二维列表）
 */
public class BinaryTraversing_Level {
	public static void main(String[] args) {
		TreeNode root = new TreeNode(3);
		root.left = new TreeNode(9);
		root.right = new TreeNode(20);
		root.right.left = new TreeNode(15);
		root.right.right = new TreeNode(7);
		ArrayList<ArrayList<Integer>> res = new ArrayList<>();
		traverse(root, 0, res);
		res.forEach(System.out::println);
		System.out.println("127.0.0.1".indexOf(","));
	}

	private static void traverse(TreeNode node, int level, ArrayList<ArrayList<Integer>> res) {
		if (level == res.size()) {
			res.add(new ArrayList<>());
		}

		ArrayList<Integer> list = res.get(level);
		list.add(node.value);

		if (node.left != null) {
			traverse(node.left, level + 1, res);
		}

		if (node.right != null) {
			traverse(node.right, level + 1, res);
		}
	}

	/**
	 * 给定一个二叉树，返回其节点值自底向上的层序遍历。 （即按从叶子节点所在层到根节点所在的层，逐层从左向右遍历）
	 *
	 * @param root
	 * @return
	 */
	public List<List<Integer>> levelOrderBottom(TreeNode root) {

		LinkedList<List<Integer>> res = new LinkedList<>();
		if (root == null) {
			return res;
		}
		Queue<TreeNode> queue = new LinkedList<>();
		queue.offer(root);
		while (!queue.isEmpty()) {
			List<Integer> level = new ArrayList<>();
			int size = queue.size();
			for (int i = 0; i < size; i++) {
				TreeNode node = queue.poll();
				level.add(node.value);
				if (node.left != null)
					queue.add(node.left);
				if (node.right != null)
					queue.add(node.right);
			}
			res.addFirst(level);
		}
		return res;
	}



}

