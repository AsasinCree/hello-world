package test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class TestConcurrentLockMain {
	public static void main(String[] args) {
		//�����������ʵ��˻�
		TestConcurrentLockAccount myCount = new TestConcurrentLockAccount(1111111, 10000);
        //����һ���̳߳�
        ExecutorService pool = Executors.newCachedThreadPool(); 
        
//        //����һ��������
//        Lock lock = new ReentrantLock();
//        //����һЩ���������û���һ�����ÿ�����Ĵ棬ȡ��ȡ�������ְ�
//        TestConcurrentLockUser u1 = new TestConcurrentLockUser("����", myCount, -4000, lock); 
//        TestConcurrentLockUser u2 = new TestConcurrentLockUser("����", myCount, 6000, lock); 
//        TestConcurrentLockUser u3 = new TestConcurrentLockUser("����", myCount, -8000, lock); 
//        TestConcurrentLockUser u4 = new TestConcurrentLockUser("����", myCount, 800, lock);
//        
        ReadWriteLock lock = new ReentrantReadWriteLock(false);
        //����һЩ���������û���һ�����ÿ�����Ĵ棬ȡ��ȡ�������ְ�
        TestConcurrentReadWriteLockUser u1 = new TestConcurrentReadWriteLockUser("����", myCount, -4000, lock, false); 
        TestConcurrentReadWriteLockUser u2 = new TestConcurrentReadWriteLockUser("����", myCount, 6000, lock, true); 
        TestConcurrentReadWriteLockUser u3 = new TestConcurrentReadWriteLockUser("����", myCount, -8000, lock, false); 
        TestConcurrentReadWriteLockUser u4 = new TestConcurrentReadWriteLockUser("����", myCount, 800, lock, true);
        
        
        //���̳߳���ִ�и����û��Ĳ���
        pool.execute(u1); 
        pool.execute(u2); 
        pool.execute(u3); 
        pool.execute(u4); 
        //�ر��̳߳�
        pool.shutdown(); 
	}
}
