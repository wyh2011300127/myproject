package com.common;

import java.sql.Timestamp;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

import org.dom4j.Document;

/**
 * ���ڲ���������
 * @author zhoukun@sinovatech.com
 * @since 2013-03-01
 */
public class DateUtil {
	private static final String DEFAULT_PATTERN = "yyyy-MM-dd";
	private static transient int gregoranCutoverYear = 1582;
	/**����ÿ������**/
	private static final int[] DAYS_P_MONTH_LY = {31,29,31,30,31,30,31,31,30,31,30,31};
	/**������ÿ������**/
	private static final int[] DAYS_P_MONTH_CY = {31,28,31,30,31,30,31,31,30,31,30,31};
	/**��������������ꡢ�¡���*/
	private static final int Y = 0,M = 1,D = 2;
	/**
	 * ���ַ�����ʽת�����������ͣ�ʹ�õ���Ĭ�����ڸ�ʽ
	 * @param str
	 * @return
	 */
	public static Date str2Date(String str){
		Date d = null;
		SimpleDateFormat sdf = new SimpleDateFormat(DEFAULT_PATTERN);
		try {
			d = sdf.parse(str);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return d;
	}
	/**
	 * ���ַ�����ʽת�����������ͣ�ʹ�õ����Զ������ڸ�ʽ
	 * @param str
	 * @param pattern
	 * @return
	 */
	public static Date str2Date(String str,String pattern){
		Date d = null;
		SimpleDateFormat sdf = new SimpleDateFormat(pattern);
		try {
			d = sdf.parse(str);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return d;
	}
	/**
	 * ��dateת����Ĭ��ʱ���ʽ���ַ���
	 * @param date
	 * @return
	 */
	public static String date2Str(Date date) {
		SimpleDateFormat sdf = new SimpleDateFormat(DEFAULT_PATTERN);
		return sdf.format(date);
	}
	/**
	 * ��dateת����format��ʽ���ַ���
	 * @param date
	 * @param format
	 * @return
	 */
	public static String date2Str(Date date, String format) {
		if(date == null) {
			return "";
		}
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		return sdf.format(date);
	}
	/**
	 * ��ȡ��ǰ������ǰ����������interval��
	 * @param date
	 * @param isBefore(true:��ǰ��  false:������)
	 * @param interval
	 * @return
	 */
	public static Date getIntervalDay(Date date,Boolean isBefore,int interval){
		Calendar calendar = Calendar.getInstance(TimeZone.getDefault());
		calendar.setTime(date);
		calendar.add(Calendar.DATE,isBefore ? -interval : +interval);
		return str2Date(date2Str(calendar.getTime(),"yyyy-MM-dd HH:mm:ss"),"yyyy-MM-dd HH:mm:ss");
	}
	/**
	 * ���������������������
	 * 
	 * @param firstString
	 * @param secondString
	 * @return
	 */
	public static int daysBetweenTwoDate(String starTtime, String endTime) {
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		Date firstDate = null;
		Date secondDate = null;
		try {
			firstDate = df.parse(starTtime);
			secondDate = df.parse(endTime);
		} catch (Exception e) {
			// �������ַ�����ʽ����
			e.printStackTrace();
		}
		int nDay = (int) ((secondDate.getTime() - firstDate.getTime()) / (24 * 60 * 60 * 1000));
		return nDay;
	}

	/**
	 * �ж�����Date�Ƿ���ͬһ��
	 * @param date1
	 * @param date2
	 * @return �������Date��ͬһ�죬�򷵻�true������false
	 */
	public static boolean isTwoDatesInSameDay(Date date1, Date date2) {
		String str1 = date2Str(date1);
		String str2 = date2Str(date2);
		return str1.equals(str2);
	}
	/**
	 * �жϵ�ǰʱ���Ƿ���ָ��������
	 * @param starttime
	 * @param endtime
	 * @param isMinute(�Ƿ��ʱ����)
	 * @return
	 */
	public static boolean isNowBetweenDates(String startTime, String endTime,Boolean isMinute){
		Date sT = null;// ��ʼʱ��
		Date eT = null;// ��ֹʱ��
		if(isMinute){
			sT = DateUtil.str2Date(startTime+" 00:00:01", "yyyy-MM-dd HH:mm:ss");
			eT = DateUtil.str2Date(endTime+" 23:59:59", "yyyy-MM-dd HH:mm:ss");
		}else{
			sT = DateUtil.str2Date(startTime, "yyyy-MM-dd HH:mm:ss");
			eT = DateUtil.str2Date(endTime, "yyyy-MM-dd HH:mm:ss");
		}
		Calendar scalendar = Calendar.getInstance();
		scalendar.setTime(sT);// ��ʼʱ��
		Calendar ecalendar = Calendar.getInstance();
		ecalendar.setTime(eT);// ��ֹʱ��
		Calendar calendarnow = Calendar.getInstance();
		return calendarnow.after(scalendar) && calendarnow.before(ecalendar);
	}
	/**
	 * �жϽ����Ƿ���ָ��һ��
	 * @param date
	 * @return
	 */
	public static Boolean isSomeDay(String date){
		String today=date2Str(new Date(),"yyyy-MM-dd");
		return date.equals(today);
	}
	/**
	 * �жϽ����Ƿ���ָ������֮��
	 * @param date
	 * @return
	 */
	public static boolean isTodayAfter(String date){
		Date eT = DateUtil.str2Date(date, "yyyy-MM-dd HH:mm:ss");
		Calendar eC = Calendar.getInstance();
		eC.setTime(eT);
		Calendar now = Calendar.getInstance();
		return now.after(eC);
	}
	/**
	 * �жϽ����Ƿ���ָ������֮ǰ
	 * @param date
	 * @return
	 */
	public static boolean isTodayBefore(String date){
		Date sT = DateUtil.str2Date(date, "yyyy-MM-dd HH:mm:ss");
		Calendar sC = Calendar.getInstance();
		sC.setTime(sT);
		Calendar now = Calendar.getInstance();
		return now.before(sC);
	}

	/**
	 * �ж�ָ��ʱ��������intervalСʱ�Ƿ�ȵ�ǰʱ��С
	 * 
	 * @param time
	 * @param interval
	 * @return
	 */
	public static boolean isOverTime(Date time, int interval) {
		Calendar c = Calendar.getInstance();
		if (time == null) {
			return true;
		}
		c.setTime(time);
		c.add(Calendar.MINUTE, +interval);
		Date ee = c.getTime();
		// orderTime + Consts.ORDER_CAMP_OVER_TIMEСʱ < now ˵����ʱ��
		return ee.before(new Date());
	}
	
	/**
	 * �ж�ָ��������Ƿ�Ϊ����
	 * @param year
	 * @return
	 */
	public static boolean isLeapYear(int year){
		return year >= gregoranCutoverYear ? ((year%4 == 0) && ((year%100!=0) || (year%400 == 0))) : (year%4 == 0);
	}
	/**
	 * ���������ڵ��ַ����ָ�ɴ��������յ���������
	 * @param date
	 * @return
	 */
	public static int[] splitYMD(String date){
		date = date.replace("-", "");
		int[] ymd = {0,0,0};
		ymd[Y] = Integer.parseInt(date.substring(0,4));
		ymd[M] = Integer.parseInt(date.substring(4,6));
		ymd[D] = Integer.parseInt(date.substring(6,8));
		return ymd;
	}
	/**
	 * ��������λ���·ݻ������ڲ���Ϊ2λ
	 * @param decimal
	 * @return
	 */
	public static String formatMonthDay(int decimal){
		DecimalFormat df = new DecimalFormat("00");
		return df.format(decimal);
	}
	/**
	 * ������4λ����ݲ���Ϊ4λ
	 * @param decimal
	 * @return
	 */
	public static String formatYear(int decimal){
		DecimalFormat df = new DecimalFormat("00");
		return df.format(decimal);
	}
	/**
	 * ���ڼ�1��
	 * @param year
	 * @param month
	 * @param day
	 * @return
	 */
	private static int[] addOneDay(int year,int month,int day){
		if(isLeapYear(year)){
			day++;
			if(day > DAYS_P_MONTH_LY[month-1]){
				month++;
				if(month>12){
					year++;
					month = 1;
				}
				day = 1;
			}
		} else {
			day++;
			if(day > DAYS_P_MONTH_CY[month-1]){
				month++;
				if(month>12){
					year++;
					month = 1;
				}
				day = 1;
			}
		}
		int[] ymd = {year,month,day};
		return ymd;
	}
	/**
	 * 
	 * @param beginDate
	 * @param endDate
	 * @return
	 */
	public static int getIntervalDate(Date beginDate,Date endDate){
		long begindate = beginDate.getTime();//�õ�������
		long enddate = endDate.getTime();
	    long intval = enddate-begindate;//��ʱ�����ܺ�����
	    int  min = (int)(intval/60000);//ת���ɷ���
		return min;//���ط���
	}

	/**
	 * ����ָ��ʱ�䷶Χ�ڵ�ÿһ��
	 * @param beginDate
	 * @param endDate
	 * @param pattern
	 */
	public static List<String> getEveryDay(String beginDate,String endDate){
		int days = daysBetweenTwoDate(beginDate, endDate);
		int[] ymd = splitYMD(beginDate);
		List<String> everyDays = new ArrayList<String>();
		everyDays.add(beginDate);
		for (int i = 0; i < days; i++) {
			ymd = addOneDay(ymd[Y], ymd[M], ymd[D]);
			everyDays.add(formatYear(ymd[Y])+"-"+formatMonthDay(ymd[M])+"-"+formatMonthDay(ymd[D]));
		}
		return everyDays;
	}
	
	
	public static void main(String[] args) {
		Double k = 1010.0;
		DecimalFormat df = new DecimalFormat("#0.00");
//		System.out.println(Double.valueOf(df.format(k).toString()));
//		Double d = Double.parseDouble(df.format(k).toString());
//		System.out.print(d);
		
		String dd = "800.00";

	}
	
	public static String getLastMonth(String month) {
		Calendar c = Calendar.getInstance();
		c.setTime(str2Date(month, "yyyyMM"));
		c.add(Calendar.MONTH, -1);
		Date ee = c.getTime();
		return date2Str(ee,"yyyyMM");
	}
	
	/***
	 * �ж���ʱ���Ƿ�������������
	 * @param month
	 * @return
	 */
	public static boolean getContinueMonth(String beforeMonth,String lastMonth) {
		Calendar c = Calendar.getInstance();
		c.setTime(str2Date(beforeMonth, "yyyyMM"));
		c.add(Calendar.MONTH, -1);
		Date ee = c.getTime();
		boolean lean =  lastMonth.equals(date2Str(ee,"yyyyMM"));
		return lean;
	}
	
	/**
	 * ��ȡ��ǰ������ǰ����������interval��
	 * @param date
	 * @param isBefore(true:��ǰ��  false:������)
	 * @param interval
	 * @return
	 */
	public static String getIntervalDayStr(Date date,Boolean isBefore,int interval){
		Calendar calendar = Calendar.getInstance(TimeZone.getDefault());
		calendar.setTime(date);
		calendar.add(Calendar.DATE,isBefore ? -interval : +interval);
		return date2Str(calendar.getTime(),"yyyy-MM-dd");
	}  
	
	public static Timestamp getNow() {
		long now = System.currentTimeMillis();
		return new Timestamp(now);
	}
}
