package com.yue.learning.design;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 三个线程轮流打印A.B.C三个字母
 */
public class ThreadCommunicate {
	public static void main(String[] args) {
		Lock lock = new ReentrantLock();
		Condition a = lock.newCondition();
		Condition b = lock.newCondition();
		Condition c = lock.newCondition();
		List<Condition> list = new ArrayList<>();
		for(Condition condition:list) {
			new Thread(() -> {

				System.out.println("");
			}).start();
		}
	}
}
