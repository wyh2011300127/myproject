package com.test.abstrac;

import com.test.interfac.Interface1;
//�������ʵ�ֽӿ�
public abstract class AbstractDemo implements Interface1{

	private String gender;
	private static final int AGE = 15;

	//���󷽷�
	//abstract��method����ͬʱ��static,����ͬʱ��native������ͬʱ��synchronized
	public abstract void method();
	//public abstract static void method2();����ʵ��
	//public abstract native void method2();����ʵ��
	//public abstract synchronized void method2();����ʵ��
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
