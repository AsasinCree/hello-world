package test;

public class TestThreadSchedulingBySetPriority {
	public static void main(String[] args) {
		class Thread1 extends Thread{
			@Override
			public void run() {
				for (int i = 0; i < 7; i++) {
					System.out.println("线程1第"+i+"次执行");
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
				for (int i = 0; i < 7; i++) {
					System.out.println("线程2第"+i+"次执行");
					try {
						Thread.sleep(50);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		}
		
		//sleep无法精准保证线程执行次序
		Thread thread1 = new Thread1();
		Thread thread2 = new Thread(new MyRunnable());
		//设定优先级
		//线程的优先级用1-10之间的整数表示，数值越大优先级越高，默认的优先级为5
		//在一个线程中开启另外一个新线程，则新开线程称为该线程的子线程，子线程初始优先级与父线程相同。
		//线程的优先级仍然无法保障线程的执行次序
		thread1.setPriority(10);
		thread2.setPriority(1);
		
		thread1.start();
		thread2.start();
	}
}
