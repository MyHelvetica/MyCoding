package org.notify;

public class NotifyConsumeTest implements Runnable{
	
	public Storage aStorage;
	
	public NotifyConsumeTest(Storage aStorage) {
		this.aStorage = aStorage;
	}

	@Override
	public void run() {
		while(true) {
			synchronized (aStorage) {
				if (aStorage.num == 0) {
					try {
						aStorage.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				if (aStorage.num == 1) {
					aStorage.notifyAll();
				}
				aStorage.num--;
				System.out.println(Thread.currentThread().getName() + ":" + aStorage.num);
			}
		}
	}
}
