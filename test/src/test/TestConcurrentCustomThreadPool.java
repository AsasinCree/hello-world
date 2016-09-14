package test;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class TestConcurrentCustomThreadPool extends Thread {
	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName() + "����ִ�С���");
		try {
			Thread.sleep(100L);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		// �����ȴ�����
		BlockingQueue<Runnable> bqueue = new ArrayBlockingQueue<Runnable>(20);
		// ����һ�����߳�ִ�г������ɰ����ڸ����ӳٺ�����������߶��ڵ�ִ�С�
		ThreadPoolExecutor pool = new ThreadPoolExecutor(2, 3, 2,
				TimeUnit.MILLISECONDS, bqueue);
	/*	������
		corePoolSize -������������߳��������������̡߳�
		maximumPoolSize -�������������߳�����
		keepAliveTime -���߳������ں���ʱ����Ϊ��ֹǰ����Ŀ����̵߳ȴ���������ʱ�䡣
		unit - keepAliveTime������ʱ�䵥λ��
		workQueue -ִ��ǰ���ڱ�������Ķ��С��˶��н�������execute�����ύ��Runnable����*/
		// ����ʵ����Runnable�ӿڶ���Thread����ȻҲʵ����Runnable�ӿ�
		Thread t1 = new TestConcurrentCustomThreadPool();
		Thread t2 = new TestConcurrentCustomThreadPool();
		Thread t3 = new TestConcurrentCustomThreadPool();
		Thread t4 = new TestConcurrentCustomThreadPool();
		Thread t5 = new TestConcurrentCustomThreadPool();
		Thread t6 = new TestConcurrentCustomThreadPool();
		Thread t7 = new TestConcurrentCustomThreadPool();
		// ���̷߳�����н���ִ��
		pool.execute(t1);
		pool.execute(t2);
		pool.execute(t3);
		pool.execute(t4);
		pool.execute(t5);
		pool.execute(t6);
		pool.execute(t7);
		// �ر��̳߳�
		pool.shutdown();
	}
}
