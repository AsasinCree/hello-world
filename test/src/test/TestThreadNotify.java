package test;

public class TestThreadNotify extends Thread {
	int total = 0;

	@Override
	public void run() {
		synchronized (this) {
			for (int i = 0; i < 10; i++) {
				total += i;
			}
			notify();// 完成计算了，唤醒在此对象监视器上等待的单个线程，在本例中main线程被唤醒
		}
	}

	public static void main(String[] args) {
		TestThreadNotify testThread6 = new TestThreadNotify();
		testThread6.start();

		synchronized (testThread6) {
			System.out.println("等待对象testThread6完成计算");
			try {
				//导致当前的线程等待，直到其他线程调用【此对象】的 notify()方法或 notifyAll()方法，或者超过指定的时间量
				testThread6.wait();		
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} // 导致当前线程等待。此例为main线程

		}
		System.out.println("testThread6对象总和：" + testThread6.total);
	}

}
