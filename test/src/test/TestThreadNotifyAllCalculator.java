package test;

public class TestThreadNotifyAllCalculator extends Thread{

	public int total;
	
	@Override
	public void run() {
		synchronized (this) {		
			for (int i = 0; i < 50; i++) {
				total += i;
			}
			System.out.println("���������߳�");
			notifyAll();		//�������ͬ�������棬��Ȼ�׳�IllegalMonitorStateException�쳣����Ϊ�˷��������ڻ�ö������������ʹ��
		}		
	}
}
