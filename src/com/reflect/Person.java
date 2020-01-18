package com.reflect;

import java.io.Serializable;

import javax.swing.JFrame;

public class Person extends JFrame implements Serializable,Cloneable{
	
	public int id = 10;
	protected String name;
	
	public Person() {
		
	}
	
	public void f1() {
		
	}
	
	public String t1 () {
		return "hello";
	}
	
	public void f2 (int a) {
		System.out.println("f2");
	}
	
	public void f2 (String a, String b) {
		System.out.println("String  "+"int");
	}
}	

