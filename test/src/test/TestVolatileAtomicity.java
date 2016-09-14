package test;

public class TestVolatileAtomicity {
	public volatile int inc = 0;

	public /*synchronized*/ void increase() {		//����synchronized���ܱ�֤ÿ��10000
		inc++;		//��������ԭ����
	}
	
	public static void main(String[] args) {
		final TestVolatileAtomicity test = new TestVolatileAtomicity();
		for (int i = 0; i < 10; i++) {
			new Thread() {
				public void run() {
					for (int j = 0; j < 1000; j++)
						test.increase();
				};
			}.start();
		}

		while (Thread.activeCount() > 1)
			// ��֤ǰ����̶߳�ִ����
			Thread.yield();
		System.out.println(test.inc);
	}
}
