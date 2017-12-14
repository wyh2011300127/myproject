package com.test.thread;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * 线程
 * @author wangyuheng
 *
 */
public class Thread1 extends Thread{
	private String name;
	private static Log log = LogFactory.getLog(Thread1.class);
	
	public Thread1(){}
	public Thread1(String name) {
		this.name = name;
	}
	
	@Override
	public void run() {
		
		for (int i = 0; i < 10; i++) {
			log.info(name + "运行第" + i + "次");
		
			try {
				//int k = ((int)Math.random()*10);
				//log.info("k:"+k);
				sleep(3000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Thread1 y1 = new Thread1("A");
		Thread1 y2 = new Thread1("B");
		
		y1.start();
		y2.start();
		
	}
	
	
}







