package test;

public class TestThreadSleepJoin extends Thread {

	private String nString;

	public TestThreadSleepJoin(String nString) {
		super(nString);
	}

	public void run() {		//覆写
		for (int i = 0; i < 5; i++) {
//			for (long k = 0; k < 1000000000l; k++)
//				;		//耗时操作，此处用以下线程睡眠替代
			try {
				//线程睡眠是帮助所有线程获得运行机会的最好方法
				//线程睡眠到期自动苏醒，并返回到可运行状态，不是运行状态
				//sleep()中指定的时间是线程不会运行的最短时间。因此，sleep()方法不能保证该线程睡眠到期后就开始执行
				//sleep()是静态方法，只能控制当前正在运行的线程
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(this.getName() + " :" + i);
		}
	}

	public static void main(String[] args) {
		TestThreadSleepJoin testTread1 = new TestThreadSleepJoin("张三");
		TestThreadSleepJoin testTread2 = new TestThreadSleepJoin("李四");

		testTread1.start();
		try {
			testTread1.join();		//当前主线程等待你开启的线程testTread1执行完毕。此处即包括testTread2.start()代码在内的下方代码都会在最后执行	
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		testTread2.start();	
		
	}

}
