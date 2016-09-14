package test;

public class TestSimpleTread implements Runnable {

	private String nameString;

	public TestSimpleTread(String nameString) {
		this.nameString = nameString;
	}

	@Override
	public void run() {

		for (int i = 0; i < 5; i++) {
			TestLog4j.logger.info("我是" + nameString + "信息");
			for (long k = 0; k < 1000000000l; k++)
				; // 耗时操作
			System.out.println(nameString + ": " + i);
		}
	}

	public static void main(String[] args) {
		TestLog4j.logger.info("信息");
		TestSimpleTread testTread1 = new TestSimpleTread("张三");
		TestSimpleTread testTread2 = new TestSimpleTread("李四");

		Thread thread1 = new Thread(testTread1);
		Thread thread2 = new Thread(testTread2);

		thread1.start();
		thread2.start();
		// thread1.start(); //线程run方法一旦完成就转换为 死 状态，不可再次
		// start，抛出java.lang.IllegalThreadStateException异常
	}

}
