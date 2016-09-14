package test;


public class TestConcurrentLockConditionAccountBySynchronized {
	private int id;		//�˺�
	private int cash;	//���

	public TestConcurrentLockConditionAccountBySynchronized(int id, int cash) {
		this.id = id;
		this.cash = cash;
	}
	
	/** 
     * ��� 
     * 
     * @param x        �������
     * @param name ������
     */ 

//	public synchronized void saving(int x, String name){
//		if(x > 0){
//			cash += x;
//			System.out.println(name + "���" + x +"����ǰ���Ϊ" + cash);
//		}
//		notifyAll();
//		System.out.println("��ȡ���");
//	}
	
	public void saving(int x, String name){
		synchronized (this) {
			if(x > 0){
				cash += x;
				System.out.println(name + "���" + x +"����ǰ���Ϊ" + cash);
			}
			notifyAll();
			System.out.println("��ȡ���");
		}
	}
	
//	public void drawing(int x, String name) {
//	//	System.out.println(name+"ȡ�����");
//		while (cash - x < 0) {
//			try {
//				System.out.println(name + "ȡ��"+x+"���ɹ�  �ȴ�������");
//				wait();	//����ȡ�����
//			} catch (InterruptedException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		} 
//		cash -= x;
//		System.out.println(name + "ȡ��" + x +"����ǰ���Ϊ" + cash);
//	}
	
	public void drawing(int x, String name) {
		synchronized (this) {
			//	System.out.println(name+"ȡ�����");
			while (cash - x < 0) {
				try {
					System.out.println(name + "ȡ��"+x+"���ɹ�  �ȴ�������");
					wait();	//����ȡ�����
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} 
			cash -= x;
			System.out.println(name + "ȡ��" + x +"����ǰ���Ϊ" + cash);
		}
	}
}
