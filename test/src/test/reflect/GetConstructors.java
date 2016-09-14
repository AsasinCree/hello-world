package test.reflect;

import java.lang.reflect.Constructor;

public class GetConstructors {

	public static void main(String[] args) {
		Class<?> demo = null;
		try {
			demo=Class.forName("test.reflect.Person");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Constructor<?> cons[]=demo.getConstructors();
		for (int i = 0; i < cons.length; i++) {
            System.out.println("构造方法：  "+cons[i]);
        }
	}

}
