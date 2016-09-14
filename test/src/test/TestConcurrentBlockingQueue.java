package test;

import java.util.concurrent.ArrayBlockingQueue;
	
/*阻塞队列是Java5线程新特征中的内容，Java定义了阻塞队列的接口java.util.concurrent.BlockingQueue，
阻塞队列的概念是，一个指定长度的队列，如果队列满了，添加新元素的操作会被阻塞等待，直到有空位为止。
同样，当队列为空时候，请求队列元素的操作同样会阻塞等待，直到有可用元素为止*/

public class TestConcurrentBlockingQueue {
	public static void main(String[] args) {
		ArrayBlockingQueue<Integer> bQueue = new ArrayBlockingQueue<Integer>(20);
		for (int i = 0; i < 30; i++) {
			// 将指定元素添加到此队列中，如果没有可用空间，将一直等待（如果有必要）。
			try {
				bQueue.put(i);
				System.out.println("向阻塞队列中添加了元素:" + i);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println("程序到此运行结束，即将退出----");
	}
}
