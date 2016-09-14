package test;

public class TestThreadStore {		//�ֿ�
	public static final int max_size = 100;		//	�������
	public int currentSize;		//��ǰ�����
	
	public TestThreadStore(int currentSize) {
		this.currentSize = currentSize;
	}
	
	public synchronized void produce(int neednum) {
		while (neednum + currentSize > max_size) {
			System.out.println("Ҫ����������"+neednum+"����ʣ������"+(max_size - currentSize));
			try {
				System.out.println("�����̵߳ȴ���������");
				wait();		//��ǰ�����̵߳ȴ�
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		//������������
		currentSize += neednum;
		System.out.println("�Ѿ�������"+neednum+"����Ʒ���ֿ��Ϊ"+currentSize);
		
		notifyAll();
	}
	
	public synchronized void consume(int neednum) {
		while (currentSize < neednum) {
			System.out.println("Ҫ���ѵ�����"+neednum+"���������"+(currentSize));
			try {
				System.out.println("�����̵߳ȴ���������");
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		//������������
		currentSize -= neednum;
		System.out.println("�Ѿ�������"+neednum+"����Ʒ���ֿ��Ϊ"+currentSize);
		
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
