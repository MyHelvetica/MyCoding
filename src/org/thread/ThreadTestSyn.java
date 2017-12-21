package org.thread;

/**
 * Thread 多线程 线程安全
 * @author Helvetica
 *
 */
public class ThreadTestSyn extends Thread{

	public static void main(String[] args) {

		ThreadTestSyn thr = new ThreadTestSyn();
		/* 注：不要显示创建线程，请使用线程池。 */
		Thread aThread = new Thread(thr);
		Thread bThread = new Thread(thr);
		aThread.start();
		bThread.start();
	}
	
	@Override
	public void run() {
		synchronized (this) {
			/* 尽量不要使用魔法值 */
			for (int index = 0; index < 30; index++) {
				System.out.println("当前线程 " 
						+ Thread.currentThread().getName() 
						+ "：" 
						+ index);
			}
		}
	}
	
}
