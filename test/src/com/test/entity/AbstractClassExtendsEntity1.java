package com.test.entity;

public class AbstractClassExtendsEntity1 {
	private String name;
	private int age;

	public AbstractClassExtendsEntity1() {
		System.out.println("≥ı ºªØAbstractClassExtendsEntity1......");
	}

	public AbstractClassExtendsEntity1(String name, int age) {
		this.name = name;
		this.age = age;
		System.out.println(this.name + " : " + this.age);

	}

}
