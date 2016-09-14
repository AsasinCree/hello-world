package test;

public class TestThreadConsumer extends Thread{
	private int neednum;
	private TestThreadStore store; // ˽��
	
	public TestThreadConsumer(int neednum, TestThreadStore store) {
		this.neednum = neednum;
		this.store = store;
	}
	
	@Override
	public void run() {
		store.consume(neednum);
	}
}
