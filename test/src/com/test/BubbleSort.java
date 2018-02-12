package com.test;

/**
 * √∞≈›≈≈–Ú∑® 
 * @link https://www.cnblogs.com/shen-hua/p/5422676.html
 * 
 * @author wangyuheng
 * 
 */
public class BubbleSort {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// √∞≈›≈≈–Ú
		int[] arr = { 6, 3, 8, 2, 9, 1 };

		System.out.println(arr.length);
		for (int i = 0; i < arr.length - 1; i++) {
			System.out.println("i : " + i);
			for (int j = 0; j < arr.length - 1 - i; j++) {
				System.out.println("j : " + j);
				if (arr[j] > arr[j + 1]) {
					int b = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = b;
				}
				for (int a : arr) {
					System.out.print(a + " ");
				}
				System.out.println();
			}
			System.out.println();
		}
	}

}
