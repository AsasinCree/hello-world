package test;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class TestThreadSynchronizedAnother {
	private List nameList = Collections.synchronizedList(new LinkedList());

	public synchronized void add(String name) {
		nameList.add(name);
	}

	public synchronized String removeFirst() {		//没有这个同步概率出错java.lang.IndexOutOfBoundsException
		if (nameList.size() > 0)
			return (String) nameList.remove(0);
		else {
			return null;
		}
	}

	public static void main(String[] args) {
		final TestThreadSynchronizedAnother testThread5 = new TestThreadSynchronizedAnother();
		testThread5.add("a");

		class NameDropper extends Thread {
			@Override
			public void run() {
				String name = testThread5.removeFirst();
				System.out.println(Thread.currentThread().getName()+"  "+name);
			}
		}

		Thread thread1 = new NameDropper();
		Thread thread2 = new NameDropper();
		thread1.start();
		thread2.start();
	}
}
