package test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/*Java���ź���ʵ������һ��������ϵļ��������Կ���һ����Դ��������������ź���Ҫ�����壬
�ź����������ڶ��̵߳Ĵ����У����ܼ���ж�����Ŀ���̵߳ȴ���ȡ��Դ������ͨ���ź������Ե�֪������Դ����Ŀ�ȵȣ�
����������ǿ������Ŀ�����֣�������ָ��������Щ�ڵȴ�����Щ��Դ����*/

public class TestConcurrentSemaphoreMain {
	public static void main(String[] args) {
		TestConcurrentSemaphorePool myPool = new TestConcurrentSemaphorePool(20);
        //�����̳߳�
        ExecutorService threadPool = Executors.newFixedThreadPool(2); 
        TestConcurrentSemaphoreThread t1 = new TestConcurrentSemaphoreThread("����A", myPool, 3); 
        TestConcurrentSemaphoreThread t2 = new TestConcurrentSemaphoreThread("����B", myPool, 12); 
        TestConcurrentSemaphoreThread t3 = new TestConcurrentSemaphoreThread("����C", myPool, 7); 
        //���̳߳���ִ������
        threadPool.execute(t1); 
        threadPool.execute(t2); 
        threadPool.execute(t3); 
        //�رճ�
        threadPool.shutdown(); 
	}
}