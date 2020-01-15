package com.classloader;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

import javax.sql.rowset.RowSetWarning;

public class Class_loader extends ClassLoader{

	/*
	 * �����õ�class�ڣ�
	 * E:\����ʦ\����ʦ  �Ĵ�����\Java�Ĵ�������������ʦ\ClassLeaner\bin\com\classloader
	 */
	
	/**
	 * ��ȡ�ļ�����Ϣ������תΪbyte[]�ĸ�ʽ
	 * @param filename
	 * @return
	 * @throws Exception 
	 */
	private byte[] getBytes(String filename) throws Exception {
		File file = new File(filename);
		long len = file.length();
		byte[] raw = new byte[(int) len];
		FileInputStream fis = new FileInputStream(file);
		//һ�ζ�ȡclass�ļ���ȫ������������
		int r = fis.read(raw);
		if (r != len)
			throw new IOException("�޷���ȡ��ȫ���ļ���"+r+"!="+len);
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
			 * definClass ������Դ�ڸ���ClassLoader��
			 * ��������ĸ�����
			 * 1.Ҫ���ص����ȫ����
			 * 2.�����Ķ������ֽڣ��������ֽ����ݣ���������byte[]��			 
			 * 3��4��������������е���һ����ȥ������
			 * */
			String classFullName1 = new String(raw,16,raw[15]);  //��¼����class�ļ��е�����
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
		Class clazz = cl.loadClass("E:\\����ʦ\\����ʦ  �Ĵ�����\\Java�Ĵ�������������ʦ\\ClassLeaner\\bin\\com\\classloader\\ClassForLoader.class");
		
		System.out.println(clazz);
		
//		Field[] fields = clazz.getDeclaredFields();
//		System.out.println(fields[1]);
		
	}
	
	
}
