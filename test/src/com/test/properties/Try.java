package com.test.properties;

public class Try {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(test("test"));
		
	}
	
	public static String test(String str){
		try{
			if ("test".equals(2)){
				System.out.println("true");
				return "equals";
			} else {
				throw new RuntimeException("�׳��쳣");
				//System.out.println("false");
				//return "not equals";
			}
		}catch(Exception e){
			e.printStackTrace();
			System.out.println("�����쳣��");
		}finally{
			System.out.println("���뵽finally");
		}
		return "test����";
	}

}
