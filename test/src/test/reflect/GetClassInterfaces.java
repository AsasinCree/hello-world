package test.reflect;

public class GetClassInterfaces {

	public static void main(String[] args) {
		Class<?> demo = null;
		try {
			demo = Class.forName("test.reflect.PersonChina");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Class<?> intes[] = demo.getInterfaces();
		for (int i = 0; i < intes.length; i++) {
            System.out.println("ʵ�ֵĽӿ�   "+intes[i].getName());
        }

	}

}