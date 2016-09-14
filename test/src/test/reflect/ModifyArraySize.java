package test.reflect;

import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class ModifyArraySize {

	public static void main(String[] args) throws NoSuchFieldException,
			SecurityException, IllegalArgumentException, IllegalAccessException {
		int[] temp = { 1, 2, 3, 4, 5 };
		int[] newtemp = (int[]) arrayInc(temp, 15);
		print(newtemp);
		System.out.println("=====================");
		String[] atr = { "a", "b", "c" };
		String[] str1 = (String[]) arrayInc(atr, 8);
		print(str1);
	}

	public static Object arrayInc(Object obj, int len) {
		Class<?> arr = obj.getClass().getComponentType();
		Object newArr = Array.newInstance(arr, len);
		int co = Array.getLength(obj);
		System.arraycopy(obj, 0, newArr, 0, co);
		return newArr;
	}

	public static void print(Object obj) {
		Class<?> c = obj.getClass();
		if (!c.isArray()) {
			return;
		}
		System.out.println("数组长度为" + Array.getLength(obj));
		for (int i = 0; i < Array.getLength(obj); i++) {
			System.out.print(Array.get(obj, i) + "  ");
		}
	}
}
