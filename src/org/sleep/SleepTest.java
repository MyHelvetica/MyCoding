package org.sleep;

/**
 * Sleep 测试
 * @author Helvetica
 *
 */
public class SleepTest implements Runnable{

	public static void main(String[] args) {
		
		SleepTest rTest = new SleepTest();
		/* 注：不要显示创建线程，请使用线程池。 */
		Thread aThread = new Thread(rTest);

		/* 尽量不要使用魔法值 */
		for (int index = 0; index < 100; index++) {
			
			System.out.println(Thread.currentThread().getName() + " " + index);
			
			if (30 == index) {
				aThread.start();
				try {
					// 主线程暂停，立刻执行 aThread
					Thread.sleep(1);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}

	@Override
	public void run() {
		/* 尽量不要使用魔法值 */
		for (int index = 0; index < 30; index++) {
			System.out.println("当前线程 " 
		+ Thread.currentThread().getName() 
		+ "：" 
		+ index);
		}
	}
}
