package test;


public class TestConcurrentLockConditionDrawThread extends Thread {
	private String name;
	private TestConcurrentLockConditionAccount account;
	private TestConcurrentLockConditionAccountBySynchronized accountS;
	private int x;

	public TestConcurrentLockConditionDrawThread(String name,
			TestConcurrentLockConditionAccount account, int x) {
		super();
		this.name = name;
		this.account = account;
		this.x = x;
	}
	
	public TestConcurrentLockConditionDrawThread(String name,
			TestConcurrentLockConditionAccountBySynchronized accountS, int x) {
		super();
		this.name = name;
		this.accountS = accountS;
		this.x = x;
	}

	@Override
	public void run() {
		accountS.drawing(x, name);
	}
}
