package com.test;

import java.util.Calendar;
import java.util.Date;

public class Test3 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*Date date = new Date();
		System.out.println(date);
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		// cal.add(Calendar.DAY_OF_MONTH, 1);
		int hour = cal.get(Calendar.HOUR_OF_DAY);
		int minute = cal.get(Calendar.MINUTE);
		int second = cal.get(Calendar.SECOND);
		System.out.println(hour);
		cal.add(Calendar.HOUR_OF_DAY, 23 - hour);
		cal.add(Calendar.MINUTE, 59 - minute);
		cal.add(Calendar.SECOND, 60 - second);
		System.out.println(cal.getTime());
		cal.add(Calendar.DAY_OF_MONTH, 8);
		System.out.println(cal.getTime());
		System.out.println(cal.getTimeInMillis());
		System.out.println(cal.get(Calendar.DAY_OF_MONTH));
		Calendar calNow = Calendar.getInstance();
		calNow.setTime(new Date());
		System.out.println(calNow.getTime());
		System.out.println(calNow.getTimeInMillis());
		if (cal.getTimeInMillis() < calNow.getTimeInMillis()) {
			System.err.println("确认收货已经超过7 天");
		} else {
			System.err.println("未到第二天开始算往后延迟7天");
		}*/
		System.out.println(new Date());
		Date date = new Date();
		System.out.println(date);
		String str = DateUtil.date2Str(date, "yyyy-MM-dd 00:00:00");
		System.out.println(str);
		
		Date date1 = DateUtil.getIntervalDay(DateUtil.str2Date(str), false, 8);
		System.out.println(date1);
		
	}

}
