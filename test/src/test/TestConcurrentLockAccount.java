package test;

public class TestConcurrentLockAccount {
	private int id;
	private int cash;

	public TestConcurrentLockAccount(int id, int cash) {
		this.id = id;
		this.cash = cash;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getCash() {
		return cash;
	}

	public void setCash(int cash) {
		this.cash = cash;
	}

	@Override
	public String toString() {
		return "TestConcurrentLockCount [id=" + id + ", cash=" + cash + "]";
	}
}
