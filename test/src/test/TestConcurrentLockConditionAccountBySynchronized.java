package test;


public class TestConcurrentLockConditionAccountBySynchronized {
	private int id;		//账号
	private int cash;	//余额

	public TestConcurrentLockConditionAccountBySynchronized(int id, int cash) {
		this.id = id;
		this.cash = cash;
	}
	
	/** 
     * 存款 
     * 
     * @param x        操作金额
     * @param name 操作人
     */ 

//	public synchronized void saving(int x, String name){
//		if(x > 0){
//			cash += x;
//			System.out.println(name + "存款" + x +"，当前余额为" + cash);
//		}
//		notifyAll();
//		System.out.println("来取款吧");
//	}
	
	public void saving(int x, String name){
		synchronized (this) {
			if(x > 0){
				cash += x;
				System.out.println(name + "存款" + x +"，当前余额为" + cash);
			}
			notifyAll();
			System.out.println("来取款吧");
		}
	}
	
//	public void drawing(int x, String name) {
//	//	System.out.println(name+"取款操作");
//		while (cash - x < 0) {
//			try {
//				System.out.println(name + "取款"+x+"不成功  等待。。。");
//				wait();	//阻塞取款操作
//			} catch (InterruptedException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		} 
//		cash -= x;
//		System.out.println(name + "取款" + x +"，当前余额为" + cash);
//	}
	
	public void drawing(int x, String name) {
		synchronized (this) {
			//	System.out.println(name+"取款操作");
			while (cash - x < 0) {
				try {
					System.out.println(name + "取款"+x+"不成功  等待。。。");
					wait();	//阻塞取款操作
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} 
			cash -= x;
			System.out.println(name + "取款" + x +"，当前余额为" + cash);
		}
	}
}
