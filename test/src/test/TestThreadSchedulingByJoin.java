package test;

public class TestThreadSchedulingByJoin extends Thread{
	@Override
	public void run() {
		for (int i = 0; i < 7; i++) {
			System.out.println("���̵߳�"+i+"��ִ��");
		}
	}
	
	public static void main(String[] args) {

		Thread thread = new TestThreadSchedulingByJoin();
		thread.start();
		
		for (int i = 0; i < 7; i++) {
			System.out.println("���̵߳�"+i+"��ִ��");
			if(i > 2){
				try {
					////thread�̺߳ϲ������߳��У����߳�ִֹͣ�й��̣�ת��ִ��thread�̣߳�ֱ��threadִ����Ϻ������
					thread.join();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
}
