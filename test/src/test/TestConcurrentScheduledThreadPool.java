package test;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class TestConcurrentScheduledThreadPool extends Thread{
	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName()+"正在执行。。");
	}
	public static void main(String[] args) {
   //     ScheduledExecutorService pool = Executors.newScheduledThreadPool(2);		//创建一个线程池，它可安排在给定延迟后运行命令或者定期地执行。	
        ScheduledExecutorService pool = Executors.newSingleThreadScheduledExecutor();		//创建一个单线程执行程序，它可安排在给定延迟后运行命令或者定期地执行。
        
        //创建实现了Runnable接口对象，Thread对象当然也实现了Runnable接口
        Thread t1 = new TestConcurrentScheduledThreadPool();
        Thread t2 = new TestConcurrentScheduledThreadPool();
        Thread t3 = new TestConcurrentScheduledThreadPool();
        Thread t4 = new TestConcurrentScheduledThreadPool();
        Thread t5 = new TestConcurrentScheduledThreadPool();
        //将线程放入池中进行执行
        pool.execute(t1); 
        pool.execute(t2); 
        pool.execute(t3); 
        //使用延迟执行风格的方法
        pool.schedule(t4, 1000, TimeUnit.MILLISECONDS); 
        pool.schedule(t5, 10, TimeUnit.MILLISECONDS); 
        //关闭线程池
        pool.shutdown(); 
	}

}
