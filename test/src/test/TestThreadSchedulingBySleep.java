package test;

public class TestThreadSchedulingBySleep {
	public static void main(String[] args) {
		class Thread1 extends Thread{
			@Override
			public void run() {
				for (int i = 0; i < 3; i++) {
					System.out.println("�߳�1��"+i+"��ִ��");
					try {
						Thread.sleep(50);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		}
		
		class MyRunnable implements Runnable{
			@Override
			public void run() {
				for (int i = 0; i < 3; i++) {
					System.out.println("�߳�2��"+i+"��ִ��");
					try {
						Thread.sleep(50);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		}
		
		//sleep�޷���׼��֤�߳�ִ�д���
		Thread thread1 = new Thread1();
		Thread thread2 = new Thread(new MyRunnable());
		thread1.start();
		thread2.start();
	}
}
