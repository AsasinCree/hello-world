package test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicLong;

/*ԭ������Ȼ���Ա�֤����������ĳһ���������̵İ�ȫ�����޷���֤����������飬������������İ�ȫ�ԡ�
��ˣ�ͨ����Ӧ��ʹ������ͬ��������������������İ�ȫ��*/

public class TestConcurrentAtomic extends Thread{
	private static AtomicLong aLong = new AtomicLong(10000);		//ԭ������ÿ���̶߳��������ɲ���
	private String name;
	private int x ;
	
	public TestConcurrentAtomic(String name, int x) {
		super();
		this.name = name;
		this.x = x;
	}

	@Override
	public void run() {
		System.out.println(name+"ִ����" + x +"����ǰ��" + aLong.addAndGet(x));
	}
	
	public static void main(String[] args) {
		 ExecutorService pool = Executors.newFixedThreadPool(2); 
         Runnable t1 = new TestConcurrentAtomic("����", 2000);
         Runnable t2 = new TestConcurrentAtomic("����", 3600);
         Runnable t3 = new TestConcurrentAtomic("����", 2700);
         Runnable t4 = new TestConcurrentAtomic("����", 600);
         Runnable t5 = new TestConcurrentAtomic("��ţ", 1300);
         Runnable t6 = new TestConcurrentAtomic("����", 800);
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
