package test;

public class TestThreadNotifyAllCalculator extends Thread{

	public int total;
	
	@Override
	public void run() {
		synchronized (this) {		
			for (int i = 0; i < 50; i++) {
				total += i;
			}
			System.out.println("唤醒其他线程");
			notifyAll();		//必须放在同步块里面，不然抛出IllegalMonitorStateException异常，因为此方法必须在获得对象锁的情况下使用
		}		
	}
}
