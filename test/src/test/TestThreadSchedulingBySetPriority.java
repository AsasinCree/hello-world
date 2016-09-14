package test;

public class TestThreadSchedulingBySetPriority {
	public static void main(String[] args) {
		class Thread1 extends Thread{
			@Override
			public void run() {
				for (int i = 0; i < 7; i++) {
					System.out.println("�߳�1��"+i+"��ִ��");
					try {
						Thread.sleep(50);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		}
		
		class MyRunnable implements Runnable{
			@Override
			public void run() {
				for (int i = 0; i < 7; i++) {
					System.out.println("�߳�2��"+i+"��ִ��");
					try {
						Thread.sleep(50);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		}
		
		//sleep�޷���׼��֤�߳�ִ�д���
		Thread thread1 = new Thread1();
		Thread thread2 = new Thread(new MyRunnable());
		//�趨���ȼ�
		//�̵߳����ȼ���1-10֮���������ʾ����ֵԽ�����ȼ�Խ�ߣ�Ĭ�ϵ����ȼ�Ϊ5
		//��һ���߳��п�������һ�����̣߳����¿��̳߳�Ϊ���̵߳����̣߳����̳߳�ʼ���ȼ��븸�߳���ͬ��
		//�̵߳����ȼ���Ȼ�޷������̵߳�ִ�д���
		thread1.setPriority(10);
		thread2.setPriority(1);
		
		thread1.start();
		thread2.start();
	}
}
