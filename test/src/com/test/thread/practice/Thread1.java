package com.test.thread.practice;

public class Thread1 implements Runnable{
	private static int count = 10;
	public Thread1(){}
	
	public static void method() {
		synchronized(Thread1.class){
			for(int i=0;i<10;i++){
				try {
					System.out.println(Thread.currentThread().getName() + ":"
							+ count--);
					Thread.sleep(100);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Thread1 t1 = new Thread1();
		Thread1 t2 = new Thread1();
		new Thread(t1, "t1").start();
		new Thread(t2, "t2").start();
	}

	@Override
	public void run() {
		method();
	}

}
