package test;

public class TestThreadDeadLockMain extends Thread {
	private TestThreadDeadLock deadLock;
	private int a;
	private int b;

	public TestThreadDeadLockMain(TestThreadDeadLock deadLock, int a, int b) {
		this.deadLock = deadLock;
		this.a = a;
		this.b = b;
	}

	@Override
	public void run() {
		deadLock.read();
		System.out.println(Thread.currentThread().getName() + "线程读取完毕");
		deadLock.write(a, b);
		System.out.println(Thread.currentThread().getName() + "线程写入完毕");
	}

	public static void main(String[] args) {
		final TestThreadDeadLock deadLock = new TestThreadDeadLock();

		Thread thread1 = new TestThreadDeadLockMain(deadLock, 2, 2);
		Thread thread2 = new TestThreadDeadLockMain(deadLock, 2, 2);
		Thread thread3 = new TestThreadDeadLockMain(deadLock, 2, 2);
		Thread thread4 = new TestThreadDeadLockMain(deadLock, 2, 2);
		thread1.start();
		thread2.start();
		thread3.start();
		thread4.start();
	}
}
