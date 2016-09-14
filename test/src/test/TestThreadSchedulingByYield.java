package test;

public class TestThreadSchedulingByYield {
	public static void main(String[] args) {
		class Thread1 extends Thread{
			@Override
			public void run() {
				for (int i = 0; i < 7; i++) {
					System.out.println("�߳�1��"+i+"��ִ��");
				}
			}
		}
		
		class MyRunnable implements Runnable{
			@Override
			public void run() {
				for (int i = 0; i < 7; i++) {
					System.out.println("�߳�2��"+i+"��ִ��");
					
					//�̵߳ĵ���-�ò�
					//�̵߳��ò��������ʹ��ǰ�������߳��ó�CPU��Դ������Ȼ��˭��֪�����������ó����߳�״̬�ص�������״̬
					//���ǣ�ʵ�����޷���֤yield()�ﵽ�ò�Ŀ�ģ���Ϊ�ò����̻߳��п��ܱ��̵߳��ȳ����ٴ�ѡ�С�
					Thread.yield();
				}
			}
		}
		
		//sleep�޷���׼��֤�߳�ִ�д���
		Thread thread1 = new Thread1();
		Thread thread2 = new Thread(new MyRunnable());
		
		thread2.start();
		thread1.start();
	}
}
