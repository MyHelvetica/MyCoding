package org.join;

/**
 * Join 测试 2
 * @author Helvetica
 *
 */
public class JoinTest2 implements Runnable{
	
	private static int result = 0;

	public static void main(String[] args) {
		
		JoinTest2 rTest = new JoinTest2();
		/* 注：不要显示创建线程，请使用线程池。 */
		Thread aThread = new Thread(rTest);
		aThread.start();
		try {
			aThread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(result);
	}

	/**
	 * 某个线程执行需要一定时间返回，如果不使用 join，则主线程不会等待，直接返回了 0
	 */
	@Override
	public void run() {
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		result = 1000;
	}
}
