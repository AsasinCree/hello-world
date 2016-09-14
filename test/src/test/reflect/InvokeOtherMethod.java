package test.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class InvokeOtherMethod {

	public static void main(String[] args) {
		Class<?> demo = null;
		try {
			demo = Class.forName("test.reflect.PersonChina");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//调用Person类中的sayChina方法
        Method method;
		try {
			method = demo.getMethod("sayChina");
			 method.invoke(demo.newInstance());
		        //调用Person的sayHello方法
		        method=demo.getMethod("sayHello", String.class,int.class);
		        method.invoke(demo.newInstance(),"Rollen",20);
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
       
	}

}
