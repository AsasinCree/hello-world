package test.reflect;

public class ClassInstantiation {

	public static void main(String[] args) {
		Class<?> demo1 = null;
		Class<?> demo2 = null;
		Class<?> demo3 = null;
		
		try {
			demo1 = Class.forName("test.reflect.Demo");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		demo2 = new Demo().getClass();
		demo3 = Demo.class;
		
		System.out.println("������   "+demo1.getName());
        System.out.println("������   "+demo2.getName());
        System.out.println("������   "+demo3.getName());
	}

}