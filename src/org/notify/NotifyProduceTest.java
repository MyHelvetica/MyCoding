package org.notify;

public class NotifyProduceTest implements Runnable{
	
	public Storage aStorage;
	
	public NotifyProduceTest(Storage aStorage) {
		this.aStorage = aStorage;
	}

	@Override
	public void run() {
		while(true) {
			synchronized (aStorage) {
				if (aStorage.num == 10) {
					try {
						aStorage.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				if (aStorage.num == 9) {
					aStorage.notifyAll();
				}
				aStorage.num++;
				System.out.println(Thread.currentThread().getName() + ":" + aStorage.num);
			}
		}
	}
}
