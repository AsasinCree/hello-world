package test;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class TestConcurrentCallable implements Callable<Object>{
	//Java线程：有返回值的线程
	private String oid;
	
	public TestConcurrentCallable(String oid) {
		 this.oid = oid;
	}
	
	@Override
	public Object call() throws Exception {
		return oid+"    任务返回的内容";
	}
	
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		Callable<Object> c1 = new TestConcurrentCallable("A");
		Callable<Object> c2 = new TestConcurrentCallable("B");
		
		 //创建一个线程池
        ExecutorService pool = Executors.newFixedThreadPool(2); 
        Future<Object> f1 = pool.submit(c1);
        Future<Object> f2 = pool.submit(c2);
        
      //从Future对象上获取任务的返回值，并输出到控制台
        System.out.println(">>>"+f1.get().toString());
        System.out.println(">>>"+f2.get().toString());
        //关闭线程池
        pool.shutdown();
	}
}