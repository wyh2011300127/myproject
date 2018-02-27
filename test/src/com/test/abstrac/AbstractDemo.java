package com.test.abstrac;

import com.test.interfac.Interface1;
//抽象类可实现接口
public abstract class AbstractDemo implements Interface1{

	private String gender;
	private static final int AGE = 15;

	//抽象方法
	//abstract的method不可同时是static,不可同时是native，不可同时是synchronized
	public abstract void method();
	//public abstract static void method2();错误实例
	//public abstract native void method2();错误实例
	//public abstract synchronized void method2();错误实例
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
