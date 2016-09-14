package test;

import java.util.concurrent.Semaphore;

public class TestConcurrentSemaphorePool{
	private Semaphore sp;	 //池相关的信号量
	
	 /** 
     * 池的大小，这个大小会传递给信号量
     * 
     * @param size 池的大小
     */ 
	public TestConcurrentSemaphorePool(int size) {
		sp = new Semaphore(size);
	}

	public Semaphore getSp() {
		return sp;
	}

	public void setSp(Semaphore sp) {
		this.sp = sp;
	}
	
	
}