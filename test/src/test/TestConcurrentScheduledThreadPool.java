package test;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class TestConcurrentScheduledThreadPool extends Thread{
	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName()+"����ִ�С���");
	}
	public static void main(String[] args) {
   //     ScheduledExecutorService pool = Executors.newScheduledThreadPool(2);		//����һ���̳߳أ����ɰ����ڸ����ӳٺ�����������߶��ڵ�ִ�С�	
        ScheduledExecutorService pool = Executors.newSingleThreadScheduledExecutor();		//����һ�����߳�ִ�г������ɰ����ڸ����ӳٺ�����������߶��ڵ�ִ�С�
        
        //����ʵ����Runnable�ӿڶ���Thread����ȻҲʵ����Runnable�ӿ�
        Thread t1 = new TestConcurrentScheduledThreadPool();
        Thread t2 = new TestConcurrentScheduledThreadPool();
        Thread t3 = new TestConcurrentScheduledThreadPool();
        Thread t4 = new TestConcurrentScheduledThreadPool();
        Thread t5 = new TestConcurrentScheduledThreadPool();
        //���̷߳�����н���ִ��
        pool.execute(t1); 
        pool.execute(t2); 
        pool.execute(t3); 
        //ʹ���ӳ�ִ�з��ķ���
        pool.schedule(t4, 1000, TimeUnit.MILLISECONDS); 
        pool.schedule(t5, 10, TimeUnit.MILLISECONDS); 
        //�ر��̳߳�
        pool.shutdown(); 
	}

}
