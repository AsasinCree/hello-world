package test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class TestConcurrentLockMain {
	public static void main(String[] args) {
		//创建并发访问的账户
		TestConcurrentLockAccount myCount = new TestConcurrentLockAccount(1111111, 10000);
        //创建一个线程池
        ExecutorService pool = Executors.newCachedThreadPool(); 
        
//        //创建一个锁对象
//        Lock lock = new ReentrantLock();
//        //创建一些并发访问用户，一个信用卡，存的存，取的取，好热闹啊
//        TestConcurrentLockUser u1 = new TestConcurrentLockUser("张三", myCount, -4000, lock); 
//        TestConcurrentLockUser u2 = new TestConcurrentLockUser("他爹", myCount, 6000, lock); 
//        TestConcurrentLockUser u3 = new TestConcurrentLockUser("儿子", myCount, -8000, lock); 
//        TestConcurrentLockUser u4 = new TestConcurrentLockUser("老婆", myCount, 800, lock);
//        
        ReadWriteLock lock = new ReentrantReadWriteLock(false);
        //创建一些并发访问用户，一个信用卡，存的存，取的取，好热闹啊
        TestConcurrentReadWriteLockUser u1 = new TestConcurrentReadWriteLockUser("张三", myCount, -4000, lock, false); 
        TestConcurrentReadWriteLockUser u2 = new TestConcurrentReadWriteLockUser("他爹", myCount, 6000, lock, true); 
        TestConcurrentReadWriteLockUser u3 = new TestConcurrentReadWriteLockUser("儿子", myCount, -8000, lock, false); 
        TestConcurrentReadWriteLockUser u4 = new TestConcurrentReadWriteLockUser("老婆", myCount, 800, lock, true);
        
        
        //在线程池中执行各个用户的操作
        pool.execute(u1); 
        pool.execute(u2); 
        pool.execute(u3); 
        pool.execute(u4); 
        //关闭线程池
        pool.shutdown(); 
	}
}
