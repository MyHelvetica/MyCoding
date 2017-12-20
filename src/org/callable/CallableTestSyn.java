package org.callable;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * Callable 测试
 * @author Helvetica
 *
 */
public class CallableTestSyn implements Callable<String>{

	public static void main(String[] args) {

		// 创建 CallableTest 对象
		Callable<String> myCallable = new CallableTestSyn(); 
		
		// 使用FutureTask来包装MyCallable对象
		FutureTask<String> ft1 = new FutureTask<String>(myCallable); 
		
		// 使用FutureTask来包装MyCallable对象
		FutureTask<String> ft2 = new FutureTask<String>(myCallable); 
		
		/* 不要显示创建线程，请使用线程池。 */
		Thread aThread = new Thread(ft1);
		Thread bThread = new Thread(ft2);
		
		aThread.start();
		bThread.start();
		try {
			System.out.println(ft1.get());
			System.out.println(ft2.get());
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

	@Override
	public String call() throws Exception {
		synchronized (this) {
			/* 尽量不要使用魔法值 */
			for (int index = 0; index < 30; index++) {
				System.out.println("当前线程 " 
						+ Thread.currentThread().getName() 
						+ "：" 
						+ index);
			}
		}
		return Thread.currentThread().getName() + "OK";
	}
}
