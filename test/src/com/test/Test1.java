package com.test;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.Map;

public class Test1 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try {
//			test1();
			//test2();
			//test3();
			//Integer age = Test1.map.get("zhangsan");
			//System.out.println(age);
			//FruitType fruit = FruitType.RED;
			//Color c1 = Color.RED;
			//System.out.println(c1);
			//Light l = Light.RED;
			//System.out.println(l);
			//transteEnumList();
			//testEnumMap();
			//String str = "";
			//System.out.println(str.length());
			//int b = test5();
			//System.out.println(b);
			//StringBuffer error = new StringBuffer();
			//System.out.println(error.length());
			System.out.println(Test1.class);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static int test5(){
		int b = 0;
		try {
			int a = 1 / 1;
			b = 1;
		} catch (Exception e) {
			e.printStackTrace();
			b = 5;
		}
		return b;
	}
	
	public enum FruitType {//ö������
		RED,GREEN,BLUE
	}
	
	public enum Color{
		RED("��ɫ", 1),BLUE("��ɫ", 2),GREEN("��ɫ", 3);
		private String name;
		private int age;
		private Color(String name, int age){
			this.name = name;
			this.age = age;
		}
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
	}
	
	public enum Light{//ö�����ͳ�ʼ��ֵ
		RED(1), BLUE(2), GREEN(3);
		private int nCode;
		private Light(int _nCode){
			this.nCode = _nCode;
		}
		@Override
		public String toString(){
			return String.valueOf(this.nCode);
		}
	}
	
	private static void transteEnumList(){//����ö��
		Light[] lightList = Light.values();
		for(Light light : lightList) {
			System.out.println("Light:" + light);
			System.out.println("light.name():" + light.name());
			System.out.println("light.ordinal():" + light.ordinal());
		}
	}
	
	private static void testEnumMap(){//ö��MAP
		EnumMap<Light, String> enumMap = new EnumMap<Light, String>(Light.class);
		enumMap.put(Light.RED, "��ɫ");
		enumMap.put(Light.BLUE, "��ɫ");
		enumMap.put(Light.GREEN, "��ɫ");
		for (Light light : Light.values()) {
			System.err.println("light.name():" + light.name() + ",enumMap.get(light):" + enumMap.get(light));
		}
		
	}
	
	private static Map<String, Integer> map = new HashMap<String, Integer>(){
		private static final long serialVersionUID = 1L;
		{
			put("zhangsan", 15);
			put("lisi", 14);
			put("wangwu", 17);
			put("zhaoliu", 14);
			put("qianqi", 15);
			put("sunba", 15);
			put("majiu", 16);
		}
	};
	
	
	public static void test4(){
		int aaa = 0;
		String $123 = "wer";
		String _123 = "123";
		String Aswe233 = "eqw";
	}
	
	public void test3(){
		System.out.println(111);
	}
	
	public class Test2{
		private String name;
		private String age;
		public Test2(){}
		public Test2(String name, String age){
			this.name = name;
			this.age = age;
		}
		//�ڲ������ʹ���ⲿ��ķ�����������̬������
		public void test22(){
			test1();
			test3();
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getAge() {
			return age;
		}
		public void setAge(String age) {
			this.age = age;
		}
	}
	
	public static void test2() throws Exception{
		String str = ((Math.random() + 1) - 1.5 > 0) ? null : "fals";
		if (("fals").equals(str)){//ʹ��equals�Ƚ�ʱ����֪�ַ�������ǰ�棬���ⱨ��ָ���쳣
			System.out.println("123");
		} else {
			System.out.println("456");
		}
		char c;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("�����ַ�, ���� 'q' ���˳���");
		do{
			c = (char) br.read();
			System.out.println(c);
		}while(c != 'q');
		
		
		
	}
	
	public static void test1(){
		String str = "";
		if (str != null && !str.equals("")) {
			System.out.println("!!!");
		} else {
			System.out.println("&&&");
		}
		//&&��·Ч��
		str = ""; //demo,"",
		int y = 0;
		if (++y > 0 && !str.equals("")) {//!str.equals("") && ++y > 0
			System.out.println("if:" + y);
		} else {
			System.out.println("else:" + y);
		}
		
		///////////////////////////////////////////
		int[][] arr = {{1,2},{5,6,7,8,9},{1,2,3,4}};
		boolean found = false;//����
		for (int i=0; i < arr.length; i++) {
			for ( int j=0; j < arr[i].length; j++ ){
				if (arr[i][j] == 5) {
					found = true;
					break;
				}
			}
		}
		if (found) {
			System.out.println("true");
		}
		int a = Integer.MAX_VALUE;
		int b = Integer.MIN_VALUE;
		int sum = a + b;
		System.out.println("a=" + a + ",b=" + b + ",sum=" + sum);
		/////////////////////////////////////
		short s1 = 1;
		short s2 = (short) (s1 + 1);
		s1 += 1;
	}

}
