package org.runnable;

/**
 * 多个线程随机调用
 * @author Helvetica
 *
 */
public class RunnableTest implements Runnable{

	public static void main(String[] args) {
		
		RunnableTest rTest = new RunnableTest();
		/* 注：不要显示创建线程，请使用线程池。 */
		Thread aThread = new Thread(rTest);
		Thread bThread = new Thread(rTest);
		aThread.start();
		bThread.start();
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
