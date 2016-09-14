package test.reflect;

public class GetSuperclass {

	public static void main(String[] args) {
		Class<?> demo = null;
		try {
			demo = Class.forName("test.reflect.Person");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Class<?> temp = demo.getSuperclass();
		System.out.println("¼Ì³ÐµÄ¸¸ÀàÎª£º   "+temp.getName());
	}

}
