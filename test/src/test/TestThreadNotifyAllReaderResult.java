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
				System.out.println(Thread.currentThread().getName()+"�ȴ�������");
				calculator.wait();		//���ڶ����ϵ���wait()����ʱ��ִ�иô�����߳������������ڶ����ϵ���		
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(Thread.currentThread() + "������Ϊ��" + calculator.total);
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
