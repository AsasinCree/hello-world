package test.reflect;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

interface Fruit {
	public abstract void eat();
}

class Apple implements Fruit {
	@Override
	public void eat() {
		System.out.println("Apple");
	}
}

class Orange implements Fruit {
	@Override
	public void eat() {
		System.out.println("Orange");
	}
}

//构造工厂类
//也就是说以后如果我们在添加其他的实例的时候只需要修改工厂类就行了
class FactoryWithReflect {
	public static Fruit getInstance(String className) {
		Fruit f = null;
		try {
			f = (Fruit) Class.forName(className).newInstance();
		} catch (InstantiationException | IllegalAccessException
				| ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return f;
	}
}

//操作属性文件类
class initProperties{
	public static Properties getPro() throws FileNotFoundException, IOException {
		Properties pro = new Properties();
		File file = new File("src/fruit.properties");
		if(file.exists()){
			pro.load(new FileInputStream(file));
		}else {
			pro.setProperty("apple", "test.reflect.Apple");
			pro.setProperty("orange", "test.reflect.Orange");
			pro.store(new FileOutputStream(file), "FRUIT CLASS");
		}
		return pro;
	}
}

public class FactoryPatternOfDesignPatternWithReflectANDProperties {
	public static void main(String[] args) throws FileNotFoundException, IOException {
		Properties pro = initProperties.getPro();
		Fruit f = FactoryWithReflect.getInstance(pro.getProperty("apple"));
		if (f != null)
			f.eat();
	}
}