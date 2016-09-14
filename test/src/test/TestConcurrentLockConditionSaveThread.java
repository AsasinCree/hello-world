package test;


public class TestConcurrentLockConditionSaveThread extends Thread {
	private String name;
	private TestConcurrentLockConditionAccount account;
	private TestConcurrentLockConditionAccountBySynchronized accountS;
	private int x;

	public TestConcurrentLockConditionSaveThread(String name,
			TestConcurrentLockConditionAccountBySynchronized accountS, int x) {
		super();
		this.name = name;
		this.accountS = accountS;
		this.x = x;
	}
	
	public TestConcurrentLockConditionSaveThread(String name,
			TestConcurrentLockConditionAccount account, int x) {
		super();
		this.name = name;
		this.account = account;
		this.x = x;
	}

	@Override
	public void run() {
		accountS.saving(x, name);
	}
}
