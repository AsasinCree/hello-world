package test;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class TestConcurrentCustomThreadPool extends Thread {
	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName() + "正在执行。。");
		try {
			Thread.sleep(100L);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		// 创建等待队列
		BlockingQueue<Runnable> bqueue = new ArrayBlockingQueue<Runnable>(20);
		// 创建一个单线程执行程序，它可安排在给定延迟后运行命令或者定期地执行。
		ThreadPoolExecutor pool = new ThreadPoolExecutor(2, 3, 2,
				TimeUnit.MILLISECONDS, bqueue);
	/*	参数：
		corePoolSize -池中所保存的线程数，包括空闲线程。
		maximumPoolSize -池中允许的最大线程数。
		keepAliveTime -当线程数大于核心时，此为终止前多余的空闲线程等待新任务的最长时间。
		unit - keepAliveTime参数的时间单位。
		workQueue -执行前用于保持任务的队列。此队列仅保持由execute方法提交的Runnable任务。*/
		// 创建实现了Runnable接口对象，Thread对象当然也实现了Runnable接口
		Thread t1 = new TestConcurrentCustomThreadPool();
		Thread t2 = new TestConcurrentCustomThreadPool();
		Thread t3 = new TestConcurrentCustomThreadPool();
		Thread t4 = new TestConcurrentCustomThreadPool();
		Thread t5 = new TestConcurrentCustomThreadPool();
		Thread t6 = new TestConcurrentCustomThreadPool();
		Thread t7 = new TestConcurrentCustomThreadPool();
		// 将线程放入池中进行执行
		pool.execute(t1);
		pool.execute(t2);
		pool.execute(t3);
		pool.execute(t4);
		pool.execute(t5);
		pool.execute(t6);
		pool.execute(t7);
		// 关闭线程池
		pool.shutdown();
	}
}
