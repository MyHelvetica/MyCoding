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
				if (aStorage.getNum() == 10) {
					try {
						aStorage.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				aStorage.setNum(10);
				aStorage.notifyAll();
				System.out.println("满了");
			}
		}
	}
}
