package test;

import java.util.concurrent.ArrayBlockingQueue;
	
/*����������Java5�߳��������е����ݣ�Java�������������еĽӿ�java.util.concurrent.BlockingQueue��
�������еĸ����ǣ�һ��ָ�����ȵĶ��У�����������ˣ������Ԫ�صĲ����ᱻ�����ȴ���ֱ���п�λΪֹ��
ͬ����������Ϊ��ʱ���������Ԫ�صĲ���ͬ���������ȴ���ֱ���п���Ԫ��Ϊֹ*/

public class TestConcurrentBlockingQueue {
	public static void main(String[] args) {
		ArrayBlockingQueue<Integer> bQueue = new ArrayBlockingQueue<Integer>(20);
		for (int i = 0; i < 30; i++) {
			// ��ָ��Ԫ����ӵ��˶����У����û�п��ÿռ䣬��һֱ�ȴ�������б�Ҫ����
			try {
				bQueue.put(i);
				System.out.println("�����������������Ԫ��:" + i);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println("���򵽴����н����������˳�----");
	}
}
