package test;

import java.util.concurrent.Semaphore;

public class TestConcurrentSemaphorePool{
	private Semaphore sp;	 //����ص��ź���
	
	 /** 
     * �صĴ�С�������С�ᴫ�ݸ��ź���
     * 
     * @param size �صĴ�С
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