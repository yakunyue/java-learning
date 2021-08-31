package com.yue.learning.algorithm.binarytree.traversing;

import com.yue.learning.algorithm.binarytree.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * 二叉树的锯齿形层遍历
 */
public class BinaryTraversing_Saw {

	/**
	 * 锯齿形层遍历
	 */

	public List<List<Integer>> SawTraversing(TreeNode root) {

		List<List<Integer>> res = new ArrayList<>();

		Deque<TreeNode> queue = new LinkedList<>();
		queue.add(root);
		boolean flag = true;
		while (!queue.isEmpty()) {
			List<Integer> tmp = new ArrayList<>();
			int size = queue.size();
			for (int i = 0; i < size; i++) {
				if (flag) {
					TreeNode node = queue.poll();
					tmp.add(node.value);
					if (node.left != null)
						queue.offer(node.left);
					if (node.right != null)
						queue.offer(node.right);
				} else {
					TreeNode node = queue.pollLast();
					tmp.add(node.value);
					if (node.right != null)
						queue.offerFirst(node.right);
					if (node.left != null)
						queue.offerFirst(node.left);
				}
			}
			res.add(tmp);
			flag = !flag;
		}
		return res;
	}
}
