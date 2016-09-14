package test;

public class TestVolatileOrdered {
	static volatile boolean initFlag = false;
	static TestVolatileOrderedEntity test;

	public static void main(String[] args) {

		for (int i = 0; i < 20; i++) {
			new Thread() {
				public void run() {
					while (!initFlag) {
					}
					System.out.println(test.cash.toString());
				}

			}.start();
		}

		new Thread() {
			public void run() {
				test = new TestVolatileOrderedEntity("1");
				initFlag = true;
			}
		}.start();
	}
}
