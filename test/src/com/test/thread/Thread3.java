package com.test.thread;
/**
 * 如果一个类继承Thread，则不适合资源共享。但是如果实现了Runable接口的话，则很容易的实现资源共享。
 * @author wangyuheng
 *
 */
public class Thread3 extends Thread{
	private String name;
	private int count = 5;
	public Thread3(String name){
		this.name = name;
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Thread3 t3 = new Thread3("A");
		Thread3 t4 = new Thread3("B");
		
		t3.start();
		t4.start();
	}
	@Override
	public void run() {
		for (int i = 0; i < 5; i++) {
			System.out.println(name + "运行  count= " + count--);
			try {
				sleep((int) Math.random() * 10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	
	
}
