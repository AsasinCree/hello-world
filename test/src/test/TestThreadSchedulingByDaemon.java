package test;

public class TestThreadSchedulingByDaemon {
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
				for (int i = 0; i < 100000; i++) {
					System.out.println("后台守护线程第"+i+"次执行");
				}
			}
		}
		
		//JVM的垃圾回收、内存管理等线程都是守护线程
		//在做数据库应用时候，使用的数据库连接池，连接池本身也包含着很多后台线程，监控连接个数、超时时间、状态等等
	/*	参数：
	    on - 如果为true，则将该线程标记为守护线程。    
	  	抛出：    
	    IllegalThreadStateException - 如果该线程处于活动状态。    
	    SecurityException - 如果当前线程无法修改该线程。*/
		//JRE判断程序是否执行结束的标准是所有的前台执线程行完毕了，而不管后台线程的状态，因此，在使用后台县城时候一定要注意这个问题
		Thread thread1 = new Thread1();
		Thread thread2 = new Thread(new MyRunnable());
		thread2.setDaemon(true);		//写在start前面
		
		thread2.start();
		thread1.start();
	}
}
