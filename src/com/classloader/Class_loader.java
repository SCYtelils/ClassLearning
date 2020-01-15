package com.classloader;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

import javax.sql.rowset.RowSetWarning;

public class Class_loader extends ClassLoader{

	/*
	 * 测试用的class在：
	 * E:\王老师\王老师  四大神器\Java四大神器——王老师\ClassLeaner\bin\com\classloader
	 */
	
	/**
	 * 获取文件的信息，将其转为byte[]的格式
	 * @param filename
	 * @return
	 * @throws Exception 
	 */
	private byte[] getBytes(String filename) throws Exception {
		File file = new File(filename);
		long len = file.length();
		byte[] raw = new byte[(int) len];
		FileInputStream fis = new FileInputStream(file);
		//一次读取class文件的全部二进制数据
		int r = fis.read(raw);
		if (r != len)
			throw new IOException("无法读取到全部文件："+r+"!="+len);
		fis.close();
		return raw;
	}
	
	@Override
	protected Class<?> findClass(String name) {
		System.out.println(name);
		
		try {
			byte[] raw = getBytes(name);
			System.out.println(raw.length);
			/**
			 * definClass 方法来源于父类ClassLoader类
			 * 这个方法四个参数
			 * 1.要加载的类的全名称
			 * 2.这个类的二进制字节（二进制字节数据，往往都是byte[]）			 
			 * 3和4代表用这个数组中的那一部分去构建类
			 * */
			String classFullName1 = new String(raw,16,raw[15]);  //记录的是class文件中的类名
			String classFullName = classFullName1.replace('/', '.');
			System.out.println(classFullName);
			return defineClass(classFullName, raw, 0,raw.length);
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return null;
	
	}
	
	public static void main(String[] args) throws Exception {
		Class_loader cl = new Class_loader();
		Class clazz = cl.loadClass("E:\\王老师\\王老师  四大神器\\Java四大神器——王老师\\ClassLeaner\\bin\\com\\classloader\\ClassForLoader.class");
		
		System.out.println(clazz);
		
//		Field[] fields = clazz.getDeclaredFields();
//		System.out.println(fields[1]);
		
	}
	
	
}
