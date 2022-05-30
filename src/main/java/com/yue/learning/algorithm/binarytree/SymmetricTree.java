package com.yue.learning.algorithm.binarytree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class SymmetricTree {
	public static void main(String[] args) {
		TreeNode node1 = new TreeNode(1);
		TreeNode node2 = new TreeNode(2);
		TreeNode node3 = new TreeNode(2);
		TreeNode node4 = new TreeNode(3);
		TreeNode node5 = new TreeNode(1);
		TreeNode node6 = new TreeNode(1);
		TreeNode node7 = new TreeNode(1);
		node1.left = node2;
		node1.right = node3;
		node2.left = node4;
		node2.right = node5;
		node3.left = node6;
		node3.right = node7;
		System.out.println(isSymmetric1(node1));
		System.out.println(isSymmetric2(node1));
	}

	public static boolean isSymmetric1(TreeNode node) {
		if (node == null) {
			return true;
		}
		LinkedList<TreeNode> queue = new LinkedList<>();
		queue.offer(node);
		while (queue.size() > 0) {
			int len = queue.size();
			List<Integer> list = new ArrayList<>();

			for (int i = 0; i < len; i++) {
				TreeNode currNode = queue.poll();
				if (currNode != null) {
					queue.offer(currNode.left);
					queue.offer(currNode.right);
				}
				list.add(currNode != null ? currNode.value : null);
			}
			int l = 0;
			int r = list.size() - 1;
			while (l < r) {
				if (list.get(l) != list.get(r)) {
					return false;
				}
				l++;
				r--;
			}
		}
		return true;
	}

	public static boolean isSymmetric2(TreeNode node) {
		if (node == null) return true;
		return check(node.left, node.right);
	}

	private static boolean check(TreeNode left, TreeNode right) {
		if (left == null && right == null) return true;
		if ((left == null && right != null) || (left != null && right == null)) return false;
		return left.value == right.value && check(left.left, right.right) && check(left.right, right.left);
	}
}
