package com.test.thread;


/**
 * ʵ��Runnable�ӿڱȼ̳�Thread�������е����ƣ�
1�����ʺ϶����ͬ�ĳ��������߳�ȥ����ͬһ����Դ
2�������Ա���java�еĵ��̳е�����
3�������ӳ���Ľ�׳�ԣ�������Ա�����̹߳�����������ݶ���
 * @author wangyuheng
 *
 */
public class Thread4 implements Runnable{
	private int count = 15;
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// ͬһ��my��������Thread�оͲ����ԣ������ͬһ��ʵ��������my���ͻ�����쳣   
		Thread4 t = new Thread4();
		new Thread(t,"A").start();
		new Thread(t,"B").start();
		new Thread(t,"C").start();
		new Thread(t,"D").start();
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		for(int i=0;i<5;i++){
			System.out.println(Thread.currentThread().getName()+"���� count = " + count--);
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
