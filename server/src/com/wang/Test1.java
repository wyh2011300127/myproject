package com.wang;

import java.util.ArrayList;
import java.util.List;

import com.wang.yu.DemoInterface;
import com.wang.yu.Dto1;
import com.wang.yu.Dto2;
import com.wang.yu.Dto3;
import com.wang.yu.Dto4;


public class Test1 {
	
	public static void main(String[] args) {
		//�������ͣ���������ָ���������
		System.out.println("���������˵����");
		AbstractDtoDemo dto1 = new Dto1();
		AbstractDtoDemo dto2 = new Dto2();
		dto1.test2();
		dto2.test2();
		
		System.out.println("�ӿھ���˵����");
		DemoInterface dto3 = new Dto3();
		DemoInterface dto3_1 = new Dto3();
		DemoInterface dto4 = new Dto4();
		dto3.test1();
		dto3_1.test1();
		dto4.test1();
		System.out.println(dto3 == dto3_1 ? "dto3 == dto3_1" : "dto3 != dto3_1");
		/**
		 * instanceof�ж����Ƿ���ĳ���ӿ�����
		 */
		Dto4 dto5 = new Dto4();
		//����
		assert(dto4 instanceof DemoInterface);
		if (dto5 instanceof DemoInterface){
			DemoInterface demo1 = dto5;
			System.out.println(demo1);
		}
		//System.gc();
		String ss = "abc";
		String s = new String("abc");//����������String Object
		if ("abc".equals(s)) {
			System.err.println("\"abc\"  equals  s");
		} else {
			System.err.println("\"abc\"  not  equals  s");
		}
		if (ss == s) {
			System.out.println("ss == s");
		} else {
			System.out.println("ss != s");
		}
		//int  aa = 1 / 0;
		//System.out.println(aa);
		
		List<String> list = new ArrayList<String>();
		list.add("wangxinjian");
		list.add("yuangl");
		list.add("hexizi");
		list.add("gaowei");
		System.out.println(list.size());
		
		int[] arr = {1, 2, 3, 4, 5};
		System.out.println(arr.length);
		
		String string = "qwertyuioplkjhgfdsamnbvcxz";
		System.out.println(string.length());
		
		System.out.println("return score:" + test1());
		
		
	}
	public static int test1(){
		int score = 100;
		try {
			score = score / 10;
			return score;
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			score = score + 1;
			System.out.println("finally:" + score);
		}
		return 0;
	}
	/**
	 * ð������
	 */
	public void bubbleSortArray(){
		int[] arr = {12,32,41,3,57,87,53,98,78,12,43,23,14,354,231,876,334,567,3221,456,1213,456};
		
	}
}
