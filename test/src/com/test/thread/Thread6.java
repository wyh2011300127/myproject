package com.test.thread;
/**
 * ��ʱ����������SyncThread�Ķ���t1��t2��
 * �߳�thread1ִ�е���syncThread1�����е�synchronized����(run)��
 * ���߳�thread2ִ�е���syncThread2�����е�synchronized����(run)��
 * ����֪��synchronized�������Ƕ�����ʱ�����������ֱ�����t1����
 * ��t2���󣬶����������ǻ������ŵģ����γɻ��⣬���������߳̿���ͬʱִ�С�
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
						+ " ���� count-- " + count--);
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}

}
