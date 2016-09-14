package test;


public class TestConcurrentSemaphoreThread extends Thread{
	private String threadName;	 //线程的名称	
	private TestConcurrentSemaphorePool pool;	//自定义池
	private int x;		//申请信号量的大小
	public TestConcurrentSemaphoreThread(String threadName,
			TestConcurrentSemaphorePool pool, int x) {
		super();
		this.threadName = threadName;
		this.pool = pool;
		this.x = x;
	}
	
	@Override
	public void run() {
		try {
			pool.getSp().acquire(x);	//从此信号量获取给定数目的许可
			 System.out.println(threadName + "成功获取了" + x +"个许可！");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			 //释放给定数目的许可，将其返回到信号量。
            pool.getSp().release(x); 
            System.out.println(threadName + "释放了" + x +"个许可！");
		}
	}
}