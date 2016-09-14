package test;

public class TestVolatileOrderedEntity {
	public String cash;
	
	public TestVolatileOrderedEntity(String cash) {
		this.cash = cash;
	}
	
	public TestVolatileOrderedEntity() {
		// TODO Auto-generated constructor stub
	}
	
	public static void main(String[] args) {
		String a = (new TestVolatileOrderedEntity()).cash;
		a.toString();
	}
}
