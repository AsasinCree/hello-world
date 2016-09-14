package test;

public class TestThreadSleepJoin extends Thread {

	private String nString;

	public TestThreadSleepJoin(String nString) {
		super(nString);
	}

	public void run() {		//��д
		for (int i = 0; i < 5; i++) {
//			for (long k = 0; k < 1000000000l; k++)
//				;		//��ʱ�������˴��������߳�˯�����
			try {
				//�߳�˯���ǰ��������̻߳�����л������÷���
				//�߳�˯�ߵ����Զ����ѣ������ص�������״̬����������״̬
				//sleep()��ָ����ʱ�����̲߳������е����ʱ�䡣��ˣ�sleep()�������ܱ�֤���߳�˯�ߵ��ں�Ϳ�ʼִ��
				//sleep()�Ǿ�̬������ֻ�ܿ��Ƶ�ǰ�������е��߳�
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(this.getName() + " :" + i);
		}
	}

	public static void main(String[] args) {
		TestThreadSleepJoin testTread1 = new TestThreadSleepJoin("����");
		TestThreadSleepJoin testTread2 = new TestThreadSleepJoin("����");

		testTread1.start();
		try {
			testTread1.join();		//��ǰ���̵߳ȴ��㿪�����߳�testTread1ִ����ϡ��˴�������testTread2.start()�������ڵ��·����붼�������ִ��	
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		testTread2.start();	
		
	}

}
