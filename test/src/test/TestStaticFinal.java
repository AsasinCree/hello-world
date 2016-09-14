package test;

public class TestStaticFinal extends TestStaticBlockFinal{
	
	public final int x = 100;
	public final int y;		//final 未初始化可自定义传参
	public static final int z = 80;
	
	public TestStaticFinal(int y) {
		this.y = y;
	}
	
	public void f1(){		//复写父类方法
		System.out.println("sub f1");
	}
	
//	public void f2(){		//无法复写final方法
//		
//	}
	
	public void f4(final int i){	//参数为final，只可读取无法改变
	//	i++;
	}
	
	public static void main(String[] args) {
		TestStaticFinal subTest = new TestStaticFinal(2);
		subTest.f1();	//复写父类方法
		subTest.f2();	//调用父类方法
	//	subTest.f3();	//私有	
		
	//	subTest.x = 101;		//无法改变final变量值
		System.out.println(subTest.x);
		System.out.println(subTest.y);
		System.out.println(subTest.z);		//不推荐，使用下一行
		System.out.println(TestStaticFinal.z);
	}
}
