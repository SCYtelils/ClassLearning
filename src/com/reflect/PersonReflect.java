package com.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class PersonReflect {
	
	public static void main(String[] args) throws Exception {
		String className = "com.reflect.Person";
		Class class_Person = Class.forName(className);

		Object obj = class_Person.newInstance();

		//���ڳ�Ա����
		Field id = class_Person.getDeclaredField("id");
		System.out.println(id);  //��ȡ��Ա��������Ϣ
		System.out.println(id.getInt(obj));  //��ȡ��Ա������ֵ
		
		//���ڳ�Ա����
		Method f2 = class_Person.getDeclaredMethod("f2", int.class);
		f2.invoke(obj, 1);
		
		//���ڹ��췽��
		Constructor con_Person = class_Person.getDeclaredConstructor(null);
		System.out.println(con_Person);
		
		//���ڸ���ͽӿ�
		Class superClass = class_Person.getSuperclass();
		System.out.println(superClass.getSimpleName());
		
		Class[] interfaceClass = class_Person.getInterfaces();
		for (Class inter : interfaceClass) {
			System.out.println(inter.getSimpleName());
		}
		
	}
}
