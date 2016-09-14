package test;

public class TestThreadNotify extends Thread {
	int total = 0;

	@Override
	public void run() {
		synchronized (this) {
			for (int i = 0; i < 10; i++) {
				total += i;
			}
			notify();// ��ɼ����ˣ������ڴ˶���������ϵȴ��ĵ����̣߳��ڱ�����main�̱߳�����
		}
	}

	public static void main(String[] args) {
		TestThreadNotify testThread6 = new TestThreadNotify();
		testThread6.start();

		synchronized (testThread6) {
			System.out.println("�ȴ�����testThread6��ɼ���");
			try {
				//���µ�ǰ���̵߳ȴ���ֱ�������̵߳��á��˶��󡿵� notify()������ notifyAll()���������߳���ָ����ʱ����
				testThread6.wait();		
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} // ���µ�ǰ�̵߳ȴ�������Ϊmain�߳�

		}
		System.out.println("testThread6�����ܺͣ�" + testThread6.total);
	}

}
