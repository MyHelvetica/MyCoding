package org.daemon;

/**
 * 守护线程 测试
 * @author Helvetica
 *
 */
public class DaemonTest implements Runnable{

	public static void main(String[] args) {
		
		DaemonTest aTest = new DaemonTest();
		/* 不要显示创建线程，请使用线程池。 */
		Thread aThread = new Thread(aTest);
		// 设置守护线程，则主线程完毕后就关闭虚拟机，守护进程停顿了 100 毫秒后虚拟机已经关闭，不再执行。
		aThread.setDaemon(true);
		aThread.start();
	}

	@Override
	public void run() {
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("线程执行：" + Thread.currentThread().getName());
	}
}
