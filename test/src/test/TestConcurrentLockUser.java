package test;

import java.util.concurrent.locks.Lock;

public class TestConcurrentLockUser implements Runnable {
	private TestConcurrentLockAccount account;
	private String name;
	private int iocash;
	private Lock lock;

	public TestConcurrentLockUser(String name, TestConcurrentLockAccount account,
			int iocash, Lock lock) {
		super();
		this.account = account;
		this.name = name;
		this.iocash = iocash;
		this.lock = lock;
	}

	@Override
	public void run() {
		lock.lock();
		System.out.println(name + "���ڲ���" + account +"�˻������Ϊ" + iocash +"����ǰ���Ϊ" + account.getCash());
		account.setCash(account.getCash() + iocash);
		System.out.println(name + "����" + account +"�˻��ɹ������Ϊ" + iocash +"����ǰ���Ϊ" + account.getCash());
		lock.unlock();
	}
}
