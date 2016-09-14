package test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/*ԭ������Ȼ���Ա�֤����������ĳһ���������̵İ�ȫ�����޷���֤����������飬������������İ�ȫ�ԡ�
��ˣ�ͨ����Ӧ��ʹ������ͬ��������������������İ�ȫ��*/

public class TestConcurrentAtomicWithLock extends Thread{
	private static AtomicLong aLong = new AtomicLong(10000);		//ԭ������ÿ���̶߳��������ɲ���
	private String name;
	private int x ;
	private Lock lock;
	
	public TestConcurrentAtomicWithLock(String name, int x, Lock lock) {
		super();
		this.name = name;
		this.x = x;
		this.lock = lock;
	}

	@Override
	public void run() {
		lock.lock();
		System.out.println(name+"ִ����" + x +"����ǰ��" + aLong.addAndGet(x));
		lock.unlock();
	}
	
	public static void main(String[] args) {
		 ExecutorService pool = Executors.newFixedThreadPool(2); 
		 Lock lock = new ReentrantLock(false);
         Runnable t1 = new TestConcurrentAtomicWithLock("����", 2000, lock);
         Runnable t2 = new TestConcurrentAtomicWithLock("����", 3600, lock);
         Runnable t3 = new TestConcurrentAtomicWithLock("����", 2700, lock);
         Runnable t4 = new TestConcurrentAtomicWithLock("����", 600, lock);
         Runnable t5 = new TestConcurrentAtomicWithLock("��ţ", 1300, lock);
         Runnable t6 = new TestConcurrentAtomicWithLock("����", 800, lock);
         //ִ�и����߳�
         pool.execute(t1); 
         pool.execute(t2); 
         pool.execute(t3); 
         pool.execute(t4); 
         pool.execute(t5); 
         pool.execute(t6); 
         //�ر��̳߳�
         pool.shutdown(); 
	}
}
