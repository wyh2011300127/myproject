package com.test.thread;


/**
 * 实现Runnable接口比继承Thread类所具有的优势：
1）：适合多个相同的程序代码的线程去处理同一个资源
2）：可以避免java中的单继承的限制
3）：增加程序的健壮性，代码可以被多个线程共享，代码和数据独立
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
		// 同一个my，但是在Thread中就不可以，如果用同一个实例化对象my，就会出现异常   
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
			System.out.println(Thread.currentThread().getName()+"运行 count = " + count--);
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
