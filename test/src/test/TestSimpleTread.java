package test;

public class TestSimpleTread implements Runnable {

	private String nameString;

	public TestSimpleTread(String nameString) {
		this.nameString = nameString;
	}

	@Override
	public void run() {

		for (int i = 0; i < 5; i++) {
			TestLog4j.logger.info("����" + nameString + "��Ϣ");
			for (long k = 0; k < 1000000000l; k++)
				; // ��ʱ����
			System.out.println(nameString + ": " + i);
		}
	}

	public static void main(String[] args) {
		TestLog4j.logger.info("��Ϣ");
		TestSimpleTread testTread1 = new TestSimpleTread("����");
		TestSimpleTread testTread2 = new TestSimpleTread("����");

		Thread thread1 = new Thread(testTread1);
		Thread thread2 = new Thread(testTread2);

		thread1.start();
		thread2.start();
		// thread1.start(); //�߳�run����һ����ɾ�ת��Ϊ �� ״̬�������ٴ�
		// start���׳�java.lang.IllegalThreadStateException�쳣
	}

}
