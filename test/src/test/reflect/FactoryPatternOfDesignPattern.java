package test.reflect;


// ���칤����
// Ҳ����˵�Ժ�������������������ʵ����ʱ��ֻ��Ҫ�޸Ĺ����������
class Factory {
	public static Fruit getInstance(String fruitName) {
		Fruit f = null;
		if ("Apple".equals(fruitName)) {
			f = new Apple();
		}
		if ("Orange".equals(fruitName)) {
			f = new Orange();
		}
		return f;
	}
}

public class FactoryPatternOfDesignPattern {

	public static void main(String[] args) {
		Fruit f = Factory.getInstance("Apple");
		f.eat();
	}

}