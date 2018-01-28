package com.yuheng.wang.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {

	/**
	 * 日期转换为字符串
	 * @param date
	 */
	public static String dateToString(Date date) {
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
			return sdf.format(date);
		} catch (Exception e) {
			System.out.println("日期转换为字符串异常：" + e.getMessage());
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * 字符串转换为日期
	 * @param string
	 * @return
	 */
	public static Date stringToDate(String string) {
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
			return sdf.parse(string);
		} catch (ParseException e) {
			System.out.println("字符串转换为日期异常：" + e.getMessage());
			e.printStackTrace();
		}
		return null;
	}
	
	public static void main(String[] args) {
		System.out.println(DateUtil.dateToString(new Date()));
		//System.out.println(DateUtil.stringToDate("2017/12/23 22:43:21"));
	}
}


