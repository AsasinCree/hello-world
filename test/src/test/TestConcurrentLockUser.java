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
		System.out.println(name + "正在操作" + account +"账户，金额为" + iocash +"，当前金额为" + account.getCash());
		account.setCash(account.getCash() + iocash);
		System.out.println(name + "操作" + account +"账户成功，金额为" + iocash +"，当前金额为" + account.getCash());
		lock.unlock();
	}
}
