package com.test;

public class Test4 {
	private String name;
	public String gender;
	private final int age = 1;
	
	public static void main(String[] args) {
		for (int i = 0; i < 5; i++) {
			for (int j = 5; j > i; j--) {
				System.out.print("*");
			}
			System.out.println();
		}
		
	}
}
