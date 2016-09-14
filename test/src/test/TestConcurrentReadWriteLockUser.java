package test;

import java.util.concurrent.locks.ReadWriteLock;

public class TestConcurrentReadWriteLockUser implements Runnable {
	/*�����������ֶ�д����������Ϊ��ͨ����
	Ϊ��������ܣ�Java�ṩ�˶�д�����ڶ��ĵط�ʹ�ö�������д�ĵط�ʹ��д���������ƣ���һ���̶�������˳����ִ��Ч��*/
	private TestConcurrentLockAccount account;
	private String name;
	private int iocash;
	private ReadWriteLock lock;
	private boolean isCheck;

	public TestConcurrentReadWriteLockUser(String name, TestConcurrentLockAccount account,
			int iocash, ReadWriteLock lock, boolean isCheck) {
		super();
		this.account = account;
		this.name = name;
		this.iocash = iocash;
		this.lock = lock;
		this.isCheck = isCheck;
	}

	@Override
	public void run() {
		if(isCheck){
			lock.writeLock().lock();
			System.out.println(name + "���ڲ���" + account +"�˻������Ϊ" + iocash +"����ǰ���Ϊ" + account.getCash());
			account.setCash(account.getCash() + iocash);
			System.out.println(name + "����" + account +"�˻��ɹ������Ϊ" + iocash +"����ǰ���Ϊ" + account.getCash());
			lock.writeLock().unlock();
		}else {
			lock.readLock().lock();
			System.out.println("����" + name +"���ڲ�ѯ" + account +"�˻�����ǰ���Ϊ" + account.getCash());
			lock.readLock().unlock();
		}
	}
}
