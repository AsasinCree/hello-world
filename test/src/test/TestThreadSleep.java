package test;

public class TestThreadSleep extends Thread {

	public void run() {
		for (int i = 0; i < 30; i++) {
			if (i % 10 == 0)
				System.out.println("¡ª¡ª¡ª¡ª" + i);
			System.out.print(i + " ");
			try {
				Thread.sleep(1000);
				System.out.println("    Ïß³ÌË¯Ãß1Ãë£¡");
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
	}

	public static void main(String[] args) {
		new TestThreadSleep().start();
	}

}
