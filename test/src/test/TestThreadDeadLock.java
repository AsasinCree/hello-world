package test;

public class TestThreadDeadLock {
	/* 多次执行这个例子必定会发生死锁
	 * 但是实际上，这个例子发生死锁的概率很小。因为在代码内的某个点，
	 * CPU必须从读线程切换到写线程，所以，死锁基本上不能发生 */
	private static class Resource {
		public int value;
	}

	private Resource resource1 = new Resource();
	private Resource resource2 = new Resource();

	public int read() {
		synchronized (resource1) {
			System.out.println("读取方法中"+Thread.currentThread().getName()+"获得了R1锁");
			synchronized (resource2) {
				System.out.println("读取方法中"+Thread.currentThread().getName()+"获得了R2锁");
				return resource1.value + resource2.value;
			}
		}
	}

	public void write(int a, int b) {
		synchronized (resource2) {
			System.out.println("写入方法中"+Thread.currentThread().getName()+"获得了R2锁");
			synchronized (resource1) {
				System.out.println("写入方法中"+Thread.currentThread().getName()+"获得了R1锁");
				resource1.value = a;
				resource2.value = b;
			}
		}
	}
}
