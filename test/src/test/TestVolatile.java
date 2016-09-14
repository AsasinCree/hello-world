package test;

public class TestVolatile {
	//当停止线程更新了shutdownRequested变量的值之后，但是还没来得及写入主存当中，转去做其他事情了
	//那么工作由于不知道停止线程对shutdownRequested变量的更改，因此还会一直循环下去
	//使用volatile之后
	/*第一：使用volatile关键字会强制将修改的值立即写入主存；
	第二：使用volatile关键字的话，当一个线程进行修改时，会导致其他线程的工作内存中缓存变量的缓存行无效（反映到硬件层的话，就是CPU的L1或者L2缓存中对应的缓存行无效）；
	第三：由于其他线程的工作内存中缓存变量stop的缓存行无效，所以其他线程再次读取变量stop的值时会去主存读取。*/
	private volatile boolean shutdownRequested = false;
	public void shutdown() { 
		shutdownRequested = true;		//写
		System.out.println("停止信号");
	}
	public void doWork() { 
	    while (!shutdownRequested) { 	//读
	        System.out.println("信号值："+shutdownRequested+"   "+Thread.currentThread().getName()+"线程Work。。。。");
	    }
	}
	
	public static void main(String[] args) {
		final TestVolatile testVolatile = new TestVolatile();
		for (int i = 0; i < 5; i++) {
			new Thread(){
				public void run() {
					testVolatile.doWork();
				}
			}.start();
		}
		
		new Thread(){
			public void run() {
				testVolatile.shutdown();
			}
		}.start();
	}
}
