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
				if (aStorage.getNum() == 0) {
					try {
						aStorage.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				aStorage.setNum(0);
				aStorage.notifyAll();
				System.out.println("没有了");
			}
		}
	}
}
