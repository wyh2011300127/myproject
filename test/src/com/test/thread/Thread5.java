package com.test.thread;
/**
 * synchronized关键字同步锁，对同一对象加锁，不同的线程操作同一对象时，需要排队等待
 * @author wangyuheng
 *
 */
public class Thread5 implements Runnable{
	private static int count = 15;
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Thread5 t = new Thread5();
		new Thread(t,"A").start();
		new Thread(t,"B").start();
		new Thread(t,"C").start();
	}

	@Override
	public void run() {
		synchronized(this){
			for (int i = 0; i < 5; i++) {
				try {
					System.out.println(Thread.currentThread().getName()
							+ "运行 count = " + count--);
					Thread.sleep(100);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}
	

}
