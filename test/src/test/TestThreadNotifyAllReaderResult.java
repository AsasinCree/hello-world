package test;

public class TestThreadNotifyAllReaderResult extends Thread{

	TestThreadNotifyAllCalculator calculator;
	
	public TestThreadNotifyAllReaderResult(TestThreadNotifyAllCalculator calculator) {
		this.calculator = calculator;
	}
	
	@Override
	public void run() {
		synchronized (calculator) {
			try {			
				System.out.println(Thread.currentThread().getName()+"等待计算结果");
				calculator.wait();		//当在对象上调用wait()方法时，执行该代码的线程立即放弃它在对象上的锁		
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(Thread.currentThread() + "计算结果为：" + calculator.total);
		}
	}
	
	public static void main(String[] args) {
		TestThreadNotifyAllCalculator calculator = new TestThreadNotifyAllCalculator();
		
		new TestThreadNotifyAllReaderResult(calculator).start();
		new TestThreadNotifyAllReaderResult(calculator).start();
		new TestThreadNotifyAllReaderResult(calculator).start();
		
		for (long i = 0; i < 1000000000l; i++) {
			;
		}
		calculator.start();
	}

}
