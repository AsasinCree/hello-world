package test;

import java.util.concurrent.locks.ReadWriteLock;

public class TestConcurrentReadWriteLockUser implements Runnable {
	/*这种锁不区分读写，称这种锁为普通锁。
	为了提高性能，Java提供了读写锁，在读的地方使用读锁，在写的地方使用写锁，灵活控制，在一定程度上提高了程序的执行效率*/
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
			System.out.println(name + "正在操作" + account +"账户，金额为" + iocash +"，当前金额为" + account.getCash());
			account.setCash(account.getCash() + iocash);
			System.out.println(name + "操作" + account +"账户成功，金额为" + iocash +"，当前金额为" + account.getCash());
			lock.writeLock().unlock();
		}else {
			lock.readLock().lock();
			System.out.println("读：" + name +"正在查询" + account +"账户，当前金额为" + account.getCash());
			lock.readLock().unlock();
		}
	}
}
