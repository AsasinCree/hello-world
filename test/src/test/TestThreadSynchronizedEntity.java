package test;

public class TestThreadSynchronizedEntity {
	private String name;
	private int cash;
	
	public TestThreadSynchronizedEntity(String name, int cash) {
		this.name = name;
		this.cash = cash;
	}
	
	//ͬ�����뷽��
//	public synchronized void change(int y) {
//		try {
//			Thread.sleep(10);
//			this.cash += y;
//			System.out.println(Thread.currentThread().getName()+"���н���������"+y+"����ǰ�˻����Ϊ"+cash);
//			Thread.sleep(10);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}
	
	//ͬ�������
	public void change(int y) {
		try {
			Thread.sleep(10);
			synchronized(this){
				this.cash += y;
				System.out.println(Thread.currentThread().getName()+"���н���������"+y+"����ǰ�˻����Ϊ"+cash);
			}
			Thread.sleep(10);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
