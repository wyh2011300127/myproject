package com.test;

/**
 * 外部类
 * 
 * @author wangyuheng
 * 
 */
public class OutClass {

	/**
	 * 内部类
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
