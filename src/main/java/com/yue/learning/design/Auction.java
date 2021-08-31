package com.yue.learning.design;

import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 有一个车牌拍卖系统，参与竞拍的人每个人需要拍出一个价格，
 * 但是竞拍人，不能连续出价，必须有人出价以后自己才能出价，否则无效。
 * 并且每次竞拍价格区间在 1-200 元以内，请写一段代码，
 * 模拟多人竞拍 1,000 次以后，谁获得了基础价格是 4,000 元的车牌.
 */
public class Auction {

	static String threadName = "";
	public static void main(String[] args) {

		int price = 4000;
		AtomicInteger count = new AtomicInteger(0);


	}


}

class Fighter implements Runnable{
	@Override
	public void run() {
		int price = new Random().nextInt(200)+1;
		synchronized (this.getClass()){

		}
	}
}
