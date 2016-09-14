package test.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class InvokeOtherGetSet {

	public static void main(String[] args) {
		Class<?> demo = null;
		Object object = null;
		try {
			demo = Class.forName("test.reflect.PersonChina");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			object = demo.newInstance();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Method method;
		try {
			method = object.getClass().getMethod("setSex", String.class);
			method.invoke(object, "man");
			
			method = object.getClass().getMethod("getSex");
			System.out.println(method.invoke(object));
		} catch (NoSuchMethodException | SecurityException | IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
