package com.test.entity;

import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

public class TestDto {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		/*Dto dto = new Dto();
		dto.setAge("11");
		System.out.println(dto.getAge());
		dto.setAge("21");
		System.out.println(dto.getAge());*/
		System.out.println(new Date());
		Calendar cal = Calendar.getInstance();
		TimeZone time = cal.getTimeZone();
		System.out.println(time.toString());
	}

}
