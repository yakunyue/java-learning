package com.yue.learning.design;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class MyBlockingQueue<T> {
	Node<T> head;
	Node<T> tail;
	ReentrantLock lock;
	Condition isFull;
	Condition isEmpty;
	int size = 0;
	int maxSize;

	public MyBlockingQueue() {
		maxSize = 10;
		lock = new ReentrantLock();
		isFull = lock.newCondition();
		isEmpty = lock.newCondition();
		head = tail = new Node<>(null);
	}

	public void put(T t) {
		lock.lock();
		try {
			while (size == maxSize) {
				isFull.await();
			}
			Node<T> newNode = new Node<>(t);
			tail.next = newNode;
			tail = newNode;
			size++;
			isEmpty.signal();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			lock.unlock();
		}
	}

	public T get() {
		T t = null;
		lock.lock();
		try {
			while (size == 0) {
				isEmpty.await();
			}
			Node<T> h = head;
			Node<T> node = head.next;
			h.next = h;
			head = node;
			t = node.value;
			head.value = null;
			size--;
			isFull.signal();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			lock.unlock();
		}
		return t;
	}


	static class Node<T> {
		T value;
		Node<T> next;

		public Node(T t) {
			this.value = t;
		}
	}

	public static void main(String[] args) {
		MyBlockingQueue<Integer> q = new MyBlockingQueue<>();
		try {
			q.put(1);
			q.put(2);
			q.get();
			q.get();
			q.put(1);
			q.put(2);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
