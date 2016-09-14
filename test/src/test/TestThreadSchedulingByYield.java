package test;

public class TestThreadSchedulingByYield {
	public static void main(String[] args) {
		class Thread1 extends Thread{
			@Override
			public void run() {
				for (int i = 0; i < 7; i++) {
					System.out.println("线程1第"+i+"次执行");
				}
			}
		}
		
		class MyRunnable implements Runnable{
			@Override
			public void run() {
				for (int i = 0; i < 7; i++) {
					System.out.println("线程2第"+i+"次执行");
					
					//线程的调度-让步
					//线程的让步含义就是使当前运行着线程让出CPU资源，但是然给谁不知道，仅仅是让出，线程状态回到可运行状态
					//但是，实际中无法保证yield()达到让步目的，因为让步的线程还有可能被线程调度程序再次选中。
					Thread.yield();
				}
			}
		}
		
		//sleep无法精准保证线程执行次序
		Thread thread1 = new Thread1();
		Thread thread2 = new Thread(new MyRunnable());
		
		thread2.start();
		thread1.start();
	}
}
