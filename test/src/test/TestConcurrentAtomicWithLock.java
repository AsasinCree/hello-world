package test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/*原子量虽然可以保证单个变量在某一个操作过程的安全，但无法保证你整个代码块，或者整个程序的安全性。
因此，通常还应该使用锁等同步机制来控制整个程序的安全性*/

public class TestConcurrentAtomicWithLock extends Thread{
	private static AtomicLong aLong = new AtomicLong(10000);		//原子量，每个线程都可以自由操作
	private String name;
	private int x ;
	private Lock lock;
	
	public TestConcurrentAtomicWithLock(String name, int x, Lock lock) {
		super();
		this.name = name;
		this.x = x;
		this.lock = lock;
	}

	@Override
	public void run() {
		lock.lock();
		System.out.println(name+"执行了" + x +"，当前余额：" + aLong.addAndGet(x));
		lock.unlock();
	}
	
	public static void main(String[] args) {
		 ExecutorService pool = Executors.newFixedThreadPool(2); 
		 Lock lock = new ReentrantLock(false);
         Runnable t1 = new TestConcurrentAtomicWithLock("张三", 2000, lock);
         Runnable t2 = new TestConcurrentAtomicWithLock("李四", 3600, lock);
         Runnable t3 = new TestConcurrentAtomicWithLock("王五", 2700, lock);
         Runnable t4 = new TestConcurrentAtomicWithLock("老张", 600, lock);
         Runnable t5 = new TestConcurrentAtomicWithLock("老牛", 1300, lock);
         Runnable t6 = new TestConcurrentAtomicWithLock("胖子", 800, lock);
         //执行各个线程
         pool.execute(t1); 
         pool.execute(t2); 
         pool.execute(t3); 
         pool.execute(t4); 
         pool.execute(t5); 
         pool.execute(t6); 
         //关闭线程池
         pool.shutdown(); 
	}
}
