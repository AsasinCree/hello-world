package test.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class InstantiationByClass {

	public static void main(String[] args) {
		Class<?> demo = null;
		try {
			demo = Class.forName("test.reflect.Person");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// Person per0=null;per0=(Person)demo.newInstance();
		 
		 
		 Person per1=null;
	        Person per2=null;
	        Person per3=null;
	        Person per4=null;
	        //取得全部的构造函数
	        Constructor<?> cons[]=demo.getConstructors();
	        System.out.println(cons[2].toString());
	        
	        try{
	            per1=(Person)cons[2].newInstance();
	            per2=(Person)cons[3].newInstance("Rollen");
	            per3=(Person)cons[1].newInstance(20);
	            per4=(Person)cons[0].newInstance("Rollen",20);
	        }catch(Exception e){
	            e.printStackTrace();
	        }
	        System.out.println(per1);
	        System.out.println(per2);
	        System.out.println(per3);
	        System.out.println(per4);
	}
}
