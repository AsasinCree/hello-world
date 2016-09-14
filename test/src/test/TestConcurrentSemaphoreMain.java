package test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/*Java的信号量实际上是一个功能完毕的计数器，对控制一定资源的消费与回收有着很重要的意义，
信号量常常用于多线程的代码中，并能监控有多少数目的线程等待获取资源，并且通过信号量可以得知可用资源的数目等等，
这里总是在强调“数目”二字，但不能指出来有哪些在等待，哪些资源可用*/

public class TestConcurrentSemaphoreMain {
	public static void main(String[] args) {
		TestConcurrentSemaphorePool myPool = new TestConcurrentSemaphorePool(20);
        //创建线程池
        ExecutorService threadPool = Executors.newFixedThreadPool(2); 
        TestConcurrentSemaphoreThread t1 = new TestConcurrentSemaphoreThread("任务A", myPool, 3); 
        TestConcurrentSemaphoreThread t2 = new TestConcurrentSemaphoreThread("任务B", myPool, 12); 
        TestConcurrentSemaphoreThread t3 = new TestConcurrentSemaphoreThread("任务C", myPool, 7); 
        //在线程池中执行任务
        threadPool.execute(t1); 
        threadPool.execute(t2); 
        threadPool.execute(t3); 
        //关闭池
        threadPool.shutdown(); 
	}
}