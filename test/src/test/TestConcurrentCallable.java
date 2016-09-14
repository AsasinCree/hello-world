package test;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class TestConcurrentCallable implements Callable<Object>{
	//Java�̣߳��з���ֵ���߳�
	private String oid;
	
	public TestConcurrentCallable(String oid) {
		 this.oid = oid;
	}
	
	@Override
	public Object call() throws Exception {
		return oid+"    ���񷵻ص�����";
	}
	
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		Callable<Object> c1 = new TestConcurrentCallable("A");
		Callable<Object> c2 = new TestConcurrentCallable("B");
		
		 //����һ���̳߳�
        ExecutorService pool = Executors.newFixedThreadPool(2); 
        Future<Object> f1 = pool.submit(c1);
        Future<Object> f2 = pool.submit(c2);
        
      //��Future�����ϻ�ȡ����ķ���ֵ�������������̨
        System.out.println(">>>"+f1.get().toString());
        System.out.println(">>>"+f2.get().toString());
        //�ر��̳߳�
        pool.shutdown();
	}
}