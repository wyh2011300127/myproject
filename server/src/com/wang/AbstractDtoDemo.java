package com.wang;

import java.util.HashMap;
import java.util.Map;

public abstract class AbstractDtoDemo {
	//定义静态变量
	public static Map<String, Integer> map = new HashMap<String, Integer>(){
		private static final long serialVersionUID = 1L;
		{
			put("A", 1);
			put("B", 2);
			put("C", 3);
			put("D", 4);
		}
	};
	//定义成员变量
	public String name;
	public int age;
	public String gender;
	public AbstractDtoDemo(){}
	public AbstractDtoDemo(String name, int age, String gender){
		this.name = name;
		this.age = age;
		this.gender = gender;
	}
	//普通方法
	public void test1(){
		System.out.println("Enter test1 method>>>>>>");
	}
	
	//静态方法
	public static void test3(){
		System.out.println("Enter static method test3>>>>>>");
	}
	/**
	 * 抽象方法必须定位为public或者protected
	 */
	//private abstract void test5();//错误演示
	
	//抽象方法无返回值
	public abstract void test2();
	
	//抽象方法有返回值
	public abstract String test4();
	//重载抽象方法test4
	public abstract String test4(String str);
	//重载抽象方法test4
	protected abstract void test4(String str, int abc);
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	
	public static void main(String[] args) {
		AbstractDtoDemo.test3();
	}
	
}
