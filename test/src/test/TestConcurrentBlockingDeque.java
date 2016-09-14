package test;

import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingDeque;

/*����������Java5�߳��������е����ݣ�Java�������������еĽӿ�java.util.concurrent.BlockingQueue��
 �������еĸ����ǣ�һ��ָ�����ȵĶ��У�����������ˣ������Ԫ�صĲ����ᱻ�����ȴ���ֱ���п�λΪֹ��
 ͬ����������Ϊ��ʱ���������Ԫ�صĲ���ͬ���������ȴ���ֱ���п���Ԫ��Ϊֹ*/

public class TestConcurrentBlockingDeque {
	public static void main(String[] args) throws InterruptedException {
		BlockingDeque<Integer> bDeque = new LinkedBlockingDeque<Integer>(20);
		for (int i = 0; i < 20; i++) {
			// ��ָ��Ԫ����ӵ�������ջ�У����û�п��ÿռ䣬��һֱ�ȴ�������б�Ҫ����
			bDeque.putFirst(i);
			System.out.println("������ջ�������Ԫ��:" + i);
		}
		System.out.println(bDeque.pop());
		System.out.println("���򵽴����н����������˳�----");
	}
}
