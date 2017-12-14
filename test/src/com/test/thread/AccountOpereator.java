package com.test.thread;
/**
 * ��AccountOperator ���е�run�����������synchronized 
 * ��account�������������ʱ����һ���̷߳���account����ʱ��
 * ������ͼ����account������߳̽���������ֱ�����̷߳���account���������
 * Ҳ����˵˭�õ��Ǹ���˭�Ϳ��������������Ƶ��Ƕδ��롣
 * @author wangyuheng
 *
 */
public class AccountOpereator implements Runnable{
	private Account account;
	
	public AccountOpereator(Account account){
		this.account = account;
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Account account = new Account("zhang san", 10000.0f);
		AccountOpereator accountOperator = new AccountOpereator(account);

		final int THREAD_NUM = 5;
		Thread threads[] = new Thread[THREAD_NUM];
		for (int i = 0; i < THREAD_NUM; i ++) {
		   threads[i] = new Thread(accountOperator, "Thread" + i);
		   threads[i].start();
		}
	}

	@Override
	public void run() {
		synchronized (account) {
			account.doposit(500f);
			account.withdraw(500f);
			System.out.println(Thread.currentThread().getName() + ":"
					+ account.getBalance());
		}
	}

}
