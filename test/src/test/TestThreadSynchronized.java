package test;

public class TestThreadSynchronized extends Thread{

	private TestThreadSynchronizedEntity entity;		//竞争访问的资源标识为private		
	private int y = 0;
	
	public TestThreadSynchronized(String threadName, TestThreadSynchronizedEntity entity, int y) {
		super(threadName);
		this.entity = entity;
		this.y = y;
	}
	
	public void run() {		
		entity.change(y);	//同步修改变量的代码
	}
	
	public static void main(String[] args) {
		TestThreadSynchronizedEntity entity = new TestThreadSynchronizedEntity("xiaoming", 100);
		
		TestThreadSynchronized thread1 = new TestThreadSynchronized("线程A", entity, 20);
		TestThreadSynchronized thread2 = new TestThreadSynchronized("线程B", entity, -60);
		TestThreadSynchronized thread3 = new TestThreadSynchronized("线程C", entity, -80);
		TestThreadSynchronized thread4 = new TestThreadSynchronized("线程D", entity, -30);
		TestThreadSynchronized thread5 = new TestThreadSynchronized("线程E", entity, 32);
		TestThreadSynchronized thread6 = new TestThreadSynchronized("线程F", entity, 21);
		
		thread1.start();
		thread2.start();
		thread3.start();
		thread4.start();
		thread5.start();
		thread6.start();
	}
}
