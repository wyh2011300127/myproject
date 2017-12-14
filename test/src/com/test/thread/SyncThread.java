package com.test.thread;

/**
 * syncThread1��syncThread2��SyncThread����������
 * ����thread1��thread2����ִ��ʱȴ�������߳�ͬ����
 * ������Ϊrun�е����˾�̬����method������̬������������ģ�
 * ����syncThread1��syncThread2�൱������ͬһ������
 * @author wangyuheng
 *
 */
public class SyncThread implements Runnable {
	private static int count;

	public SyncThread() {
		count = 0;
	}

	public synchronized static void method() {
		for (int i = 0; i < 5; i++) {
			try {
				System.out.println(Thread.currentThread().getName() + ":"
						+ (count++));
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	@Override
	public void run() {
		method();
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		SyncThread syncThread1 = new SyncThread();
		SyncThread syncThread2 = new SyncThread();
		Thread thread1 = new Thread(syncThread1, "SyncThread1");
		Thread thread2 = new Thread(syncThread2, "SyncThread2");
		thread1.start();
		thread2.start();
	}

	/*�ܽ᣺
	A. ����synchronized�ؼ��ּ��ڷ����ϻ��Ƕ����ϣ���������õĶ����ǷǾ�̬�ģ�����ȡ�õ����Ƕ���
	���synchronized���õĶ�����һ����̬������һ���࣬����ȡ�õ����Ƕ��࣬�������еĶ���ͬһ������
	B. ÿ������ֻ��һ������lock����֮�������˭�õ������˭�Ϳ��������������Ƶ��Ƕδ��롣
	C. ʵ��ͬ����Ҫ�ܴ��ϵͳ������Ϊ���۵ģ���������������������Ծ���������ν��ͬ�����ơ�*/

}
