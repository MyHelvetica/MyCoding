package org.yield;

/**
 * yield 测试
 * @author Helvetica
 *
 */
public class YieldTest extends Thread{

	public static void main(String[] args) {

		YieldTest thr = new YieldTest();
		/* 注：不要显示创建线程，请使用线程池。 */
		Thread aThread = new Thread(thr);
		Thread bThread = new Thread(thr);
		aThread.start();
		System.out.println("aThread.isAlive():" + aThread.isAlive());
		System.out.println("bThread.isAlive():" + bThread.isAlive());
		bThread.start();
		try {
			bThread.sleep(100);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("aThread.isAlive():" + aThread.isAlive());
		System.out.println("bThread.isAlive():" + bThread.isAlive());
	}
	
	@Override
	public void run() {
		/* 尽量不要使用魔法值 */
		for (int index = 0; index < 30; index++) {
			if (10 == index) {
				Thread.yield();
			}
			System.out.println("当前线程 " 
					+ Thread.currentThread().getName() 
					+ "：" 
					+ Thread.currentThread().getId()
					+ "："
					+ index);
		}
	}
}
