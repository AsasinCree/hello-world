package test;

public class TestThreadFactory extends Thread{
	private int neednum;
	private TestThreadStore store;	//к╫сп
	
	public TestThreadFactory(int neednum, TestThreadStore store) {
		this.neednum = neednum;
		this.store = store;
	}
	
	@Override
	public void run() {
		store.produce(neednum);
	}
}
