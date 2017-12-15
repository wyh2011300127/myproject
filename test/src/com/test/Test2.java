package com.test;

public class Test2 implements Runnable{

	private Thread thread;
	private String tName; 

	Test2(String tName){
		this.tName = tName;
	}
	
	public Thread getThread() {
		return thread;
	}

	public void setThread(Thread thread) {
		this.thread = thread;
	}

	public String gettName() {
		return tName;
	}

	public void settName(String tName) {
		this.tName = tName;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}
	

	
	
}
