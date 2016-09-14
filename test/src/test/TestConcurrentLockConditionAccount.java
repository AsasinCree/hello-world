package test;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class TestConcurrentLockConditionAccount {
	private int id;		//账号
	private int cash;	//余额
	private Lock lock = new ReentrantLock();		//账户锁
	private Condition _save = lock.newCondition();	//存款条件
	private Condition _draw = lock.newCondition();	//取款条件

	public TestConcurrentLockConditionAccount(int id, int cash) {
		this.id = id;
		this.cash = cash;
	}
	
	/** 
     * 存款 
     * 
     * @param x        操作金额
     * @param name 操作人
     */ 

	public void saving(int x, String name){
		lock.lock();
		if(x > 0){
			cash += x;
			System.out.println(name + "存款" + x +"，当前余额为" + cash);
		}
		_draw.signalAll();
	//	System.out.println("来取款吧");
		lock.unlock();
	}
	
	public void drawing(int x, String name) {
		lock.lock();
	//	System.out.println(name+"取款操作");
		while (cash - x < 0) {
			try {
				System.out.println(name + "取款不成功  等待。。。");
				_draw.await();	//阻塞取款操作
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		cash -= x;
		System.out.println(name + "取款" + x +"，当前余额为" + cash);
		
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
