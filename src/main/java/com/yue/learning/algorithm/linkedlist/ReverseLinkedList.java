package com.yue.learning.algorithm.linkedlist;

/**
 * 翻转连表
 */
public class ReverseLinkedList {
	public static void main(String[] args) {
		LinkedNode node = new LinkedNode();
		LinkedNode head = node;
		node.value = (int)(Math.random()*10);
		int i = 1;
		while (i<10){
			LinkedNode next = new LinkedNode();
			next.value = (int)(Math.random()*10);
			node.next = next;
			node = next;
			i++;
		}
		print(head);
		LinkedNode reverse = reverse(head);
		print(reverse);
	}

	private static void print(LinkedNode head) {
		LinkedNode ln = head;
		while (ln!=null){
			System.out.print(ln.value+",");
			ln = ln.next;
		}
		System.out.println();
	}

	public static LinkedNode reverse(LinkedNode current){
		LinkedNode pre = null;
		LinkedNode next = null;

		while (null!=current){
			next = current.next;
			current.next = pre;
			pre = current;
			current = next;
		}
		return pre;
	}
}

class LinkedNode {
	int value;
	LinkedNode next;

}
