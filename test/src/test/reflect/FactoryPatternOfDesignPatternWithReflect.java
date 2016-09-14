package test.reflect;



public class FactoryPatternOfDesignPatternWithReflect {
	public static void main(String[] args) {
		Fruit f = FactoryWithReflect.getInstance("test.reflect.Apple");
		if (f != null)
			f.eat();
	}
}