package com.test.factoryCategory;

public class FactoryTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SendFactory sendFactory = new SendFactory();
		Sender sender = sendFactory.produce("sms");
		sender.send();
	}

}
