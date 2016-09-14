package test.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class GetClassLoader {

	public static void main(String[] args) {
		Demo demo = new Demo();
		System.out.println("¿‡º”‘ÿ∆˜  "+demo.getClass().getClassLoader().getClass().getName()	);
	}

}
