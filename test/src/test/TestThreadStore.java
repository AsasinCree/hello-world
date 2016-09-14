package test;

public class TestThreadStore {		//仓库
	public static final int max_size = 100;		//	最大库存量
	public int currentSize;		//当前库存量
	
	public TestThreadStore(int currentSize) {
		this.currentSize = currentSize;
	}
	
	public synchronized void produce(int neednum) {
		while (neednum + currentSize > max_size) {
			System.out.println("要生产的数量"+neednum+"超过剩余库存量"+(max_size - currentSize));
			try {
				System.out.println("生产线程等待。。。。");
				wait();		//当前生产线程等待
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		//满足生产条件
		currentSize += neednum;
		System.out.println("已经生产了"+neednum+"个产品，现库存为"+currentSize);
		
		notifyAll();
	}
	
	public synchronized void consume(int neednum) {
		while (currentSize < neednum) {
			System.out.println("要消费的数量"+neednum+"超过库存量"+(currentSize));
			try {
				System.out.println("消费线程等待。。。。");
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		//满促销费条件
		currentSize -= neednum;
		System.out.println("已经消费了"+neednum+"个产品，现库存为"+currentSize);
		
		notifyAll();
	}
	
	public static void main(String[] args) {
		TestThreadStore store = new TestThreadStore(30);
		
		TestThreadConsumer consumer1 = new TestThreadConsumer(50, store);
		TestThreadConsumer consumer2 = new TestThreadConsumer(20, store);
		TestThreadConsumer consumer3 = new TestThreadConsumer(30, store);
		TestThreadFactory factory1 = new TestThreadFactory(10, store);
		TestThreadFactory factory2 = new TestThreadFactory(10, store);
		TestThreadFactory factory3 = new TestThreadFactory(10, store);
		TestThreadFactory factory4 = new TestThreadFactory(10, store);
		TestThreadFactory factory5 = new TestThreadFactory(10, store);
		TestThreadFactory factory6 = new TestThreadFactory(10, store);
		TestThreadFactory factory7 = new TestThreadFactory(50, store);
		
		consumer1.start();
		consumer2.start();
		consumer3.start();
		factory1.start();
		factory2.start();
		factory3.start();
		factory4.start();
		factory5.start();
		factory6.start();
		factory7.start();
	}
}
