package org.notify;

public class MotifyTest {

	public static void main(String[] args) {

		Storage aStorage = new Storage();

		NotifyConsumeTest consumeTest = new NotifyConsumeTest(aStorage);
		NotifyProduceTest produceTest = new NotifyProduceTest(aStorage);
		Thread aThread = new Thread(consumeTest);
		Thread bThread = new Thread(produceTest);
		aThread.start();
		bThread.start();

	}

}
