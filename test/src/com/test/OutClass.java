package com.test;

/**
 * �ⲿ��
 * 
 * @author wangyuheng
 * 
 */
public class OutClass {

	/**
	 * �ڲ���
	 * 
	 * @author wangyuheng
	 * 
	 */
	private class InnerClass {
		public InnerClass() {
			System.out.println("InnerClass create");
		}
	}

	public OutClass() {
		InnerClass innerClass = new InnerClass();
		System.out.println("OutClass create");
	}

	public static void main(String[] args) {
		// OutClass outClass = new OutClass();
		// System.out.println(outClass.toString());
		BubbleSort BubbleSort = new BubbleSort();

	}
}
