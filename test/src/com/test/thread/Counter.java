package com.test.thread;

public class Counter implements Runnable{
	private static int count;
	public Counter(){
		count = 0;
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Counter c = new Counter();
		Thread thread1 = new Thread(c, "thread1");
		Thread thread2 = new Thread(c, "thread2");
		thread1.start();
		thread2.start();
		
	}
	public void addCount(){
		synchronized (this) {
			for (int i = 0; i < 5; i++) {
				try {
					System.out.println(Thread.currentThread().getName()
							+ " ÔËĞĞcount++ = " + (count++));
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	public void printCount(){
		for (int i = 0; i < 5; i++) {
			try {
				System.out.println(Thread.currentThread().getName()
						+ " count = " + count);
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	
	@Override
	public void run() {
		String name = Thread.currentThread().getName();
		if ("thread1".equals(name)) {
			addCount();
		} else if ("thread2".equals(name)) {
			printCount();
		}
		
	}
	

}
