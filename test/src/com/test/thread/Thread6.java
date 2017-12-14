package com.test.thread;
/**
 * 这时创建了两个SyncThread的对象t1和t2，
 * 线程thread1执行的是syncThread1对象中的synchronized代码(run)，
 * 而线程thread2执行的是syncThread2对象中的synchronized代码(run)；
 * 我们知道synchronized锁定的是对象，这时会有两把锁分别锁定t1对象
 * 和t2对象，而这两把锁是互不干扰的，不形成互斥，所以两个线程可以同时执行。
 * @author wangyuheng
 *
 */
public class Thread6 implements Runnable{
	private static int count;
	
	public Thread6(){
		count = 15;
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Thread6 t1 = new Thread6();
		Thread6 t2 = new Thread6();
		new Thread(t1, "A").start();
		new Thread(t2, "B").start();
		
	}

	@Override
	public void run() {
		synchronized(this){
			for (int i = 0; i < 5; i++) {
				System.out.println(Thread.currentThread().getName()
						+ " 运行 count-- " + count--);
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}

}
