package test;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicLong;

public class TestConcurrentCyclicBarrier {
	public static void main(String[] args) {
		class MainTask implements Runnable {
			@Override
			public void run() {
				System.out.println(">>>>������ִ���ˣ�<<<<");
			}
		}

		class SubTask extends Thread {
			private String name;
			private CyclicBarrier cbBarrier;

			public SubTask(String name, CyclicBarrier cbBarrier) {
				super();
				this.name = name;
				this.cbBarrier = cbBarrier;
			}

			@Override
			public void run() {
				System.out.println("[������" + name +"]��ʼִ���ˣ�");
	            for (int i = 0; i < 999999; i++) ;    //ģ���ʱ������
	            System.out.println("[������" + name +"]��ʼִ������ˣ���֪ͨ�ϰ����Ѿ���ɣ�");
	            
	            try {
					cbBarrier.await();		//
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (BrokenBarrierException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
		CyclicBarrier cBarrier = new CyclicBarrier(7, new MainTask());
		new SubTask("A", cBarrier).start();
        new SubTask("B", cBarrier).start();
        new SubTask("C", cBarrier).start();
        new SubTask("D", cBarrier).start();
        new SubTask("E", cBarrier).start();
        new SubTask("F", cBarrier).start();
        new SubTask("G", cBarrier).start();
	}
}
