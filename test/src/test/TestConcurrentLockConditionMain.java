package test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TestConcurrentLockConditionMain {
	public static void main(String[] args) {
	//	TestConcurrentLockConditionAccount account = new TestConcurrentLockConditionAccount(1111111, 1000);
		TestConcurrentLockConditionAccountBySynchronized account = new TestConcurrentLockConditionAccountBySynchronized(1111111, 1000);
		 //创建一个线程池
        ExecutorService pool = Executors.newFixedThreadPool(2); 
        Thread t1 = new TestConcurrentLockConditionSaveThread("张三", account, 2000); 
        Thread t2 = new TestConcurrentLockConditionSaveThread("李四", account, 3600); 
        Thread t3 = new TestConcurrentLockConditionDrawThread("王五", account, 2700); 
        Thread t4 = new TestConcurrentLockConditionSaveThread("老张", account, 600); 
        Thread t5 = new TestConcurrentLockConditionDrawThread("老牛", account, 1300); 
        Thread t6 = new TestConcurrentLockConditionDrawThread("胖子", account, 800); 
        //执行各个线程
        pool.execute(t1); 
        pool.execute(t2); 
        pool.execute(t3); 
        pool.execute(t4); 
        pool.execute(t5); 
        pool.execute(t6); 

        pool.shutdown(); 
	}
}
