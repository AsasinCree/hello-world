package test;

public class TestThreadSynchronizedEntity {
	private String name;
	private int cash;
	
	public TestThreadSynchronizedEntity(String name, int cash) {
		this.name = name;
		this.cash = cash;
	}
	
	//同步代码方法
//	public synchronized void change(int y) {
//		try {
//			Thread.sleep(10);
//			this.cash += y;
//			System.out.println(Thread.currentThread().getName()+"运行结束，增加"+y+"，当前账户余额为"+cash);
//			Thread.sleep(10);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}
	
	//同步代码块
	public void change(int y) {
		try {
			Thread.sleep(10);
			synchronized(this){
				this.cash += y;
				System.out.println(Thread.currentThread().getName()+"运行结束，增加"+y+"，当前账户余额为"+cash);
			}
			Thread.sleep(10);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
