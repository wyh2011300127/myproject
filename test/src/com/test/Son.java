package com.test;

public class Son extends Father {
	public String v = "Son";

	public Son() {
		super(); // ���ó���Ĺ��췽��,ֻ�ܷŵ���һ��.
		System.out.println("Son�޲������췽��������!");
		// super(); //�����,����ŵ����췽�������ǰ��.
	}

	public Son(String str) {
		super(str);
		System.out.println("Son���������췽��������!");
	}

	// �����˳����Ա����outinfo()
	public void outinfo() {
		System.out.println("Son��outinfo()����������");
	}

	public void test() {

		String v = "��������!"; // �ֲ�����v�����˳�Ա����v�ͳ������v

		System.out.println("------1-----");
		System.out.println(v); // ����ֲ�����v
		System.out.println(this.v); // ���(����)��Ա����v
		System.out.println(super.v); // ��������Ա����v

		System.out.println("------2-----");
		System.out.println(x); // ��������Ա����v,����̳ж���
		System.out.println(super.x); // ��������Ա����v

		System.out.println("------3-----");
		outinfo(); // ���������outinfo()����
		this.outinfo(); // ���������outinfo()����
		super.outinfo(); // ���ø����outinfo()����
		
		System.out.println("------4-----");
		System.out.println(hello);
		System.out.println(hello);
		System.out.println(hello);
		System.out.println(hello);
	}

	public static void main(String[] args) {
		Son son = new Son("String");
		son.test();

	}

}
