package com.test.entity;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

public class AbstractClassExtendsEntity3 {
	// 加私有构造器，子类不能访问父类构造器，使得该类不能被继承
	// private AbstractClassExtendsEntity3() {
	// }
	public static void main(String[] args) {
//		int a = 2 << 3;
//		System.out.println(a);
//		String ss = "123";
//		method(ss);
//		System.out.println(ss);
//		Map<String, String> map = new HashMap<String, String>();
//		map.put(null, null);
//		Map<String, String> tab = new Hashtable<String, String>();
//		tab.put(null, null);
		try {
			String str = new String("吃饭".getBytes(),"UTF-8");
			System.out.println(str);
			String str2 = new String("吃饭".getBytes(),"GBK");
			System.out.println(str2);
//			String str3 = new String("吃饭".getBytes(),"G");
//			System.out.println(str3);
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("吃饭".getBytes());
	}

	public static void method(String name) {
		name = "123456";
		// JDK1.7之后支持String类型
		// String k = "key";
		// switch (k) {
		// case "0":
		//
		// break;
		//
		// default:
		// break;
		// }
	}
}
class A{
	
}
class B{
	
}
