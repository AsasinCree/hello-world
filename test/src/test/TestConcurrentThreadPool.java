package test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TestConcurrentThreadPool extends Thread{
	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName()+"����ִ�С���");
	}
	public static void main(String[] args) {
	//	ExecutorService pool = Executors.newFixedThreadPool(2);		//����һ�������ù̶��߳������̳߳�
	//	ExecutorService pool = Executors.newSingleThreadExecutor();		//����һ��ʹ�õ��� worker�̵߳� Executor�����޽���з�ʽ�����и��̡߳�
		ExecutorService pool = Executors.newCachedThreadPool();		//����һ���ɸ�����Ҫ�������̵߳��̳߳أ���������ǰ������߳̿���ʱ���������ǡ�
		
		//����ʵ����Runnable�ӿڶ���Thread����ȻҲʵ����Runnable�ӿ�
		Thread t1 = new TestConcurrentThreadPool();
		Thread t2 = new TestConcurrentThreadPool();
		Thread t3 = new TestConcurrentThreadPool();
		Thread t4 = new TestConcurrentThreadPool();
		Thread t5 = new TestConcurrentThreadPool();
		
		//���̷߳�����н���ִ��
		pool.execute(t1);
		pool.execute(t2);
		pool.execute(t3);
		pool.execute(t4);
		pool.execute(t5);
		
		//�ر��̳߳�
		pool.shutdown();
	}

}
