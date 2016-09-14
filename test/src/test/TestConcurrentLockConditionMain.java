package test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TestConcurrentLockConditionMain {
	public static void main(String[] args) {
	//	TestConcurrentLockConditionAccount account = new TestConcurrentLockConditionAccount(1111111, 1000);
		TestConcurrentLockConditionAccountBySynchronized account = new TestConcurrentLockConditionAccountBySynchronized(1111111, 1000);
		 //����һ���̳߳�
        ExecutorService pool = Executors.newFixedThreadPool(2); 
        Thread t1 = new TestConcurrentLockConditionSaveThread("����", account, 2000); 
        Thread t2 = new TestConcurrentLockConditionSaveThread("����", account, 3600); 
        Thread t3 = new TestConcurrentLockConditionDrawThread("����", account, 2700); 
        Thread t4 = new TestConcurrentLockConditionSaveThread("����", account, 600); 
        Thread t5 = new TestConcurrentLockConditionDrawThread("��ţ", account, 1300); 
        Thread t6 = new TestConcurrentLockConditionDrawThread("����", account, 800); 
        //ִ�и����߳�
        pool.execute(t1); 
        pool.execute(t2); 
        pool.execute(t3); 
        pool.execute(t4); 
        pool.execute(t5); 
        pool.execute(t6); 

        pool.shutdown(); 
	}
}
