package org.join;

/**
 * Join 测试
 * @author Helvetica
 *
 */
public class JoinTest implements Runnable{

	public static void main(String[] args) {
		
		JoinTest rTest = new JoinTest();
		/* 注：不要显示创建线程，请使用线程池。 */
		Thread aThread = new Thread(rTest);

		/* 尽量不要使用魔法值 */
		for (int index = 0; index < 100; index++) {
			
			System.out.println(Thread.currentThread().getName() + " " + index);
			
			if (30 == index) {
				aThread.start();
				try {
					aThread.join();
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
