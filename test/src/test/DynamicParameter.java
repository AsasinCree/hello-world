package test;

public class DynamicParameter {
	
	public static void test(String... argStrings){
		for(int i = 0; i < argStrings.length ; i++){
			System.out.println(argStrings[i]);
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		test("11", "22", "33", "44", "55");
	}

}
