package com.wang.yu;

import com.wang.AbstractDtoDemo;
/**
 * 继承抽象类，须重写抽象类中的抽象方法，普通方法可以有需要的重写
 * @author wangyuheng
 *
 */
public class Dto1 extends AbstractDtoDemo {

	@Override
	public void test1() {
		// TODO Auto-generated method stub
		super.test1();
	}
	
	@Override
	public void test2() {
		// TODO Auto-generated method stub
		System.out.println("Dto1.test2()>>>>>");
	}

	@Override
	public String test4() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public String test4(String str) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void test4(String str, int abc) {
		// TODO Auto-generated method stub
		
	}
	
	
}
