package test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicLong;

/*原子量虽然可以保证单个变量在某一个操作过程的安全，但无法保证你整个代码块，或者整个程序的安全性。
因此，通常还应该使用锁等同步机制来控制整个程序的安全性*/

public class TestConcurrentAtomic extends Thread{
	private static AtomicLong aLong = new AtomicLong(10000);		//原子量，每个线程都可以自由操作
	private String name;
	private int x ;
	
	public TestConcurrentAtomic(String name, int x) {
		super();
		this.name = name;
		this.x = x;
	}

	@Override
	public void run() {
		System.out.println(name+"执行了" + x +"，当前余额：" + aLong.addAndGet(x));
	}
	
	public static void main(String[] args) {
		 ExecutorService pool = Executors.newFixedThreadPool(2); 
         Runnable t1 = new TestConcurrentAtomic("张三", 2000);
         Runnable t2 = new TestConcurrentAtomic("李四", 3600);
         Runnable t3 = new TestConcurrentAtomic("王五", 2700);
         Runnable t4 = new TestConcurrentAtomic("老张", 600);
         Runnable t5 = new TestConcurrentAtomic("老牛", 1300);
         Runnable t6 = new TestConcurrentAtomic("胖子", 800);
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
