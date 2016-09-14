package test;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class TestConcurrentLockConditionAccount {
	private int id;		//�˺�
	private int cash;	//���
	private Lock lock = new ReentrantLock();		//�˻���
	private Condition _save = lock.newCondition();	//�������
	private Condition _draw = lock.newCondition();	//ȡ������

	public TestConcurrentLockConditionAccount(int id, int cash) {
		this.id = id;
		this.cash = cash;
	}
	
	/** 
     * ��� 
     * 
     * @param x        �������
     * @param name ������
     */ 

	public void saving(int x, String name){
		lock.lock();
		if(x > 0){
			cash += x;
			System.out.println(name + "���" + x +"����ǰ���Ϊ" + cash);
		}
		_draw.signalAll();
	//	System.out.println("��ȡ���");
		lock.unlock();
	}
	
	public void drawing(int x, String name) {
		lock.lock();
	//	System.out.println(name+"ȡ�����");
		while (cash - x < 0) {
			try {
				System.out.println(name + "ȡ��ɹ�  �ȴ�������");
				_draw.await();	//����ȡ�����
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		cash -= x;
		System.out.println(name + "ȡ��" + x +"����ǰ���Ϊ" + cash);
		
		_save.signalAll();
		lock.unlock();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getCash() {
		return cash;
	}

	public void setCash(int cash) {
		this.cash = cash;
	}

	@Override
	public String toString() {
		return "TestConcurrentLockCount [id=" + id + ", cash=" + cash + "]";
	}
}
