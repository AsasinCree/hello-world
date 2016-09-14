package test;

import java.util.ArrayList;

public class TestStaticBlockFinal {
	public static int a = 3;
	public static final Integer in = new Integer(8);
	public static final ArrayList<String> list = new ArrayList<String>();
	
	static{		//程序启动只执行一次
		TestStaticBlockFinal.a = 0;
		System.out.println(a);
	}
	
	static{
		TestStaticBlockFinal.a = 2;
		System.out.println(a);
	}
	
	public static void main(String[] args) {
	//	in = new Integer(7);	//不可改变容器本身
	//	in.
		int i = 1000000000;
		System.out.println(i);
		 Integer a = 1000, b = 1000;
	     System.out.println(a == b);

	     Integer c = 128, d = 1287;
	     System.out.println(c == d);
	}
	public void f1(){
		System.out.println("f1");
	}
	
	public final void f2(){		//1. final修饰方法
		System.out.println("final f2");
	}
	
	private void f3(){
		System.out.println("f3");
	}
}
