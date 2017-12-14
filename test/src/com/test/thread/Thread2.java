package com.test.thread;

public class Thread2 implements Runnable{
	private String name;
	public Thread2(String name){
		this.name = name;
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Thread(new Thread2("C")).start();
		new Thread(new Thread2("D")).start();
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		for (int i = 0; i < 5; i++) {
			System.out.println(name + "ÔËÐÐ  :  " + i);
			try {
				Thread.sleep((int) Math.random() * 10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
