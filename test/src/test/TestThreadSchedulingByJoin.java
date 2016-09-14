package test;

public class TestThreadSchedulingByJoin extends Thread{
	@Override
	public void run() {
		for (int i = 0; i < 7; i++) {
			System.out.println("分线程第"+i+"次执行");
		}
	}
	
	public static void main(String[] args) {

		Thread thread = new TestThreadSchedulingByJoin();
		thread.start();
		
		for (int i = 0; i < 7; i++) {
			System.out.println("主线程第"+i+"次执行");
			if(i > 2){
				try {
					////thread线程合并到主线程中，主线程停止执行过程，转而执行thread线程，直到thread执行完毕后继续。
					thread.join();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
}
