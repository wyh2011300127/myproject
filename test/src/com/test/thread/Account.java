package com.test.thread;

import java.io.Serializable;

public class Account implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7355548885074952186L;
	
	private String name;
	private float money;
	
	public Account(String name, float money){
		this.name = name ;
		this.money = money;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public float getMoney() {
		return money;
	}

	public void setMoney(float money) {
		this.money = money;
	}
	// ¥Ê«Æ
	public void doposit(float money){
		this.money += money;
	      try {
	         Thread.sleep(100);
	      } catch (InterruptedException e) {
	         e.printStackTrace();
	      }
	}
	
	// »°«Æ
	public void withdraw(float money){
		this.money -= money;
	      try {
	         Thread.sleep(100);
	      } catch (InterruptedException e) {
	         e.printStackTrace();
	      }
	}
		
	 public float getBalance() {
	      return money;
	   }	
	
}
