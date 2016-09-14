package test;

public class TestThreadDeadLock {
	/* ���ִ��������ӱض��ᷢ������
	 * ����ʵ���ϣ�������ӷ��������ĸ��ʺ�С����Ϊ�ڴ����ڵ�ĳ���㣬
	 * CPU����Ӷ��߳��л���д�̣߳����ԣ����������ϲ��ܷ��� */
	private static class Resource {
		public int value;
	}

	private Resource resource1 = new Resource();
	private Resource resource2 = new Resource();

	public int read() {
		synchronized (resource1) {
			System.out.println("��ȡ������"+Thread.currentThread().getName()+"�����R1��");
			synchronized (resource2) {
				System.out.println("��ȡ������"+Thread.currentThread().getName()+"�����R2��");
				return resource1.value + resource2.value;
			}
		}
	}

	public void write(int a, int b) {
		synchronized (resource2) {
			System.out.println("д�뷽����"+Thread.currentThread().getName()+"�����R2��");
			synchronized (resource1) {
				System.out.println("д�뷽����"+Thread.currentThread().getName()+"�����R1��");
				resource1.value = a;
				resource2.value = b;
			}
		}
	}
}
