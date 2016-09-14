package test;

public class TestVolatile {
	//��ֹͣ�̸߳�����shutdownRequested������ֵ֮�󣬵��ǻ�û���ü�д�����浱�У�תȥ������������
	//��ô�������ڲ�֪��ֹͣ�̶߳�shutdownRequested�����ĸ��ģ���˻���һֱѭ����ȥ
	//ʹ��volatile֮��
	/*��һ��ʹ��volatile�ؼ��ֻ�ǿ�ƽ��޸ĵ�ֵ����д�����棻
	�ڶ���ʹ��volatile�ؼ��ֵĻ�����һ���߳̽����޸�ʱ���ᵼ�������̵߳Ĺ����ڴ��л�������Ļ�������Ч����ӳ��Ӳ����Ļ�������CPU��L1����L2�����ж�Ӧ�Ļ�������Ч����
	���������������̵߳Ĺ����ڴ��л������stop�Ļ�������Ч�����������߳��ٴζ�ȡ����stop��ֵʱ��ȥ�����ȡ��*/
	private volatile boolean shutdownRequested = false;
	public void shutdown() { 
		shutdownRequested = true;		//д
		System.out.println("ֹͣ�ź�");
	}
	public void doWork() { 
	    while (!shutdownRequested) { 	//��
	        System.out.println("�ź�ֵ��"+shutdownRequested+"   "+Thread.currentThread().getName()+"�߳�Work��������");
	    }
	}
	
	public static void main(String[] args) {
		final TestVolatile testVolatile = new TestVolatile();
		for (int i = 0; i < 5; i++) {
			new Thread(){
				public void run() {
					testVolatile.doWork();
				}
			}.start();
		}
		
		new Thread(){
			public void run() {
				testVolatile.shutdown();
			}
		}.start();
	}
}
