package test;


public class TestConcurrentSemaphoreThread extends Thread{
	private String threadName;	 //�̵߳�����	
	private TestConcurrentSemaphorePool pool;	//�Զ����
	private int x;		//�����ź����Ĵ�С
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
			pool.getSp().acquire(x);	//�Ӵ��ź�����ȡ������Ŀ�����
			 System.out.println(threadName + "�ɹ���ȡ��" + x +"����ɣ�");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			 //�ͷŸ�����Ŀ����ɣ����䷵�ص��ź�����
            pool.getSp().release(x); 
            System.out.println(threadName + "�ͷ���" + x +"����ɣ�");
		}
	}
}