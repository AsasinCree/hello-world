package test;

public class TestStaticFinal extends TestStaticBlockFinal{
	
	public final int x = 100;
	public final int y;		//final δ��ʼ�����Զ��崫��
	public static final int z = 80;
	
	public TestStaticFinal(int y) {
		this.y = y;
	}
	
	public void f1(){		//��д���෽��
		System.out.println("sub f1");
	}
	
//	public void f2(){		//�޷���дfinal����
//		
//	}
	
	public void f4(final int i){	//����Ϊfinal��ֻ�ɶ�ȡ�޷��ı�
	//	i++;
	}
	
	public static void main(String[] args) {
		TestStaticFinal subTest = new TestStaticFinal(2);
		subTest.f1();	//��д���෽��
		subTest.f2();	//���ø��෽��
	//	subTest.f3();	//˽��	
		
	//	subTest.x = 101;		//�޷��ı�final����ֵ
		System.out.println(subTest.x);
		System.out.println(subTest.y);
		System.out.println(subTest.z);		//���Ƽ���ʹ����һ��
		System.out.println(TestStaticFinal.z);
	}
}
