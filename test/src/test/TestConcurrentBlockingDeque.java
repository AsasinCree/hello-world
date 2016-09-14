package test;

import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingDeque;

/*阻塞队列是Java5线程新特征中的内容，Java定义了阻塞队列的接口java.util.concurrent.BlockingQueue，
 阻塞队列的概念是，一个指定长度的队列，如果队列满了，添加新元素的操作会被阻塞等待，直到有空位为止。
 同样，当队列为空时候，请求队列元素的操作同样会阻塞等待，直到有可用元素为止*/

public class TestConcurrentBlockingDeque {
	public static void main(String[] args) throws InterruptedException {
		BlockingDeque<Integer> bDeque = new LinkedBlockingDeque<Integer>(20);
		for (int i = 0; i < 20; i++) {
			// 将指定元素添加到此阻塞栈中，如果没有可用空间，将一直等待（如果有必要）。
			bDeque.putFirst(i);
			System.out.println("向阻塞栈中添加了元素:" + i);
		}
		System.out.println(bDeque.pop());
		System.out.println("程序到此运行结束，即将退出----");
	}
}
