package test;

public class TestThreadSchedulingByDaemon {
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
				for (int i = 0; i < 100000; i++) {
					System.out.println("��̨�ػ��̵߳�"+i+"��ִ��");
				}
			}
		}
		
		//JVM���������ա��ڴ������̶߳����ػ��߳�
		//�������ݿ�Ӧ��ʱ��ʹ�õ����ݿ����ӳأ����ӳر���Ҳ�����źܶ��̨�̣߳�������Ӹ�������ʱʱ�䡢״̬�ȵ�
	/*	������
	    on - ���Ϊtrue���򽫸��̱߳��Ϊ�ػ��̡߳�    
	  	�׳���    
	    IllegalThreadStateException - ������̴߳��ڻ״̬��    
	    SecurityException - �����ǰ�߳��޷��޸ĸ��̡߳�*/
		//JRE�жϳ����Ƿ�ִ�н����ı�׼�����е�ǰִ̨�߳�������ˣ������ܺ�̨�̵߳�״̬����ˣ���ʹ�ú�̨�س�ʱ��һ��Ҫע���������
		Thread thread1 = new Thread1();
		Thread thread2 = new Thread(new MyRunnable());
		thread2.setDaemon(true);		//д��startǰ��
		
		thread2.start();
		thread1.start();
	}
}
