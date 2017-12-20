package org.callable;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

/**
 * Callable 测试
 * @author Helvetica
 *
 */
public class CallableTest implements Callable<Integer>{

	public static void main(String[] args) {

		Callable<Integer> myCallable = new CallableTest(); // 创建 CallableTest 对象
		FutureTask<Integer> ft1 = new FutureTask<Integer>(myCallable); // 使用FutureTask来包装MyCallable对象
		FutureTask<Integer> ft2 = new FutureTask<Integer>(myCallable); // 使用FutureTask来包装MyCallable对象
		
		/* 不要显示创建线程，请使用线程池。 */
		Thread aThread = new Thread(ft1);
		Thread bThread = new Thread(ft2);
		
		aThread.start();
		bThread.start();
	}
	

	@Override
	public Integer call() throws Exception {
		synchronized (this) {
			/* 尽量不要使用魔法值 */
			for (int index = 0; index < 30; index++) {
				System.out.println("当前线程 " 
						+ Thread.currentThread().getName() 
						+ "：" 
						+ index);
			}
		}
		return null;
	}

}
