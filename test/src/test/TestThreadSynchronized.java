package test;

public class TestThreadSynchronized extends Thread{

	private TestThreadSynchronizedEntity entity;		//�������ʵ���Դ��ʶΪprivate		
	private int y = 0;
	
	public TestThreadSynchronized(String threadName, TestThreadSynchronizedEntity entity, int y) {
		super(threadName);
		this.entity = entity;
		this.y = y;
	}
	
	public void run() {		
		entity.change(y);	//ͬ���޸ı����Ĵ���
	}
	
	public static void main(String[] args) {
		TestThreadSynchronizedEntity entity = new TestThreadSynchronizedEntity("xiaoming", 100);
		
		TestThreadSynchronized thread1 = new TestThreadSynchronized("�߳�A", entity, 20);
		TestThreadSynchronized thread2 = new TestThreadSynchronized("�߳�B", entity, -60);
		TestThreadSynchronized thread3 = new TestThreadSynchronized("�߳�C", entity, -80);
		TestThreadSynchronized thread4 = new TestThreadSynchronized("�߳�D", entity, -30);
		TestThreadSynchronized thread5 = new TestThreadSynchronized("�߳�E", entity, 32);
		TestThreadSynchronized thread6 = new TestThreadSynchronized("�߳�F", entity, 21);
		
		thread1.start();
		thread2.start();
		thread3.start();
		thread4.start();
		thread5.start();
		thread6.start();
	}
}
