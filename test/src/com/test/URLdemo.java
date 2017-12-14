package com.test;

import java.net.URLDecoder;
import java.net.URLEncoder;

public class URLdemo {
	
	private static String xml = "%3C?xml%20version=%221.0%22%20encoding=%22GBK%22?%3E%0A%3CROOT%3E%0A%09%3CREQUEST_METHOD%20type=%22string%22%3EStockOrderB2B%3C/REQUEST_METHOD%3E%0A%09%3CBAT_ID%20type=%22string%22%3ENET00000000001%3C/BAT_ID%3E%0A%09%3CSEND_TIME%20type=%22string%22%3E20171102152636%3C/SEND_TIME%3E%0A%09%3CREQUEST_INFO%3E%0A%09%09%3CMODELCODE%20type=%22string%22%3EC0133144%3C/MODELCODE%3E%0A%09%09%3CDEPTID%20type=%22string%22%3E1001715%3C/DEPTID%3E%0A%20%20%20%20%20%20%20%20%20%20%20%20%20%20%20%20%3CSERVICEID%20type=%22string%22%3ES074%3C/SERVICEID%3E%0A%09%09%3CORDERTAG%20type=%22string%22%3E2%3C/ORDERTAG%3E%0A%09%09%3CNUM%20type=%22string%22%3E1%3C/NUM%3E%0A%09%09%3CORD_LINE%20type=%22string%22%3ECD201709221508012278455%3C/ORD_LINE%3E%0A%09%09%3COP_LINE%20type=%22string%22%3E2017092266061123%3C/OP_LINE%3E%0A%09%09%3CCOLORCODE%20type=%22string%22%3E%E7%99%BD%2B%E9%87%91%3C/COLORCODE%3E%0A%09%3C/REQUEST_INFO%3E%0A%3C/ROOT%3E";
	private static String sss = "<COLORCODE type=\"string\">°×+½ð</COLORCODE>";
	
	public static void main(String[] args) {
		try {
			//String receiveXml = URLDecoder.decode(xml, "utf-8");
			//System.out.println(receiveXml);
			//String ss1 = URLEncoder.encode(sss, "utf-8");
			//System.out.println(ss1);
			String ss3 = "%3CCOLORCODE+type%3D%22string%22%3E%E7%99%BD+%E9%87%91%3C%2FCOLORCODE%3E";
			ss3 = ss3.replaceAll("\\+", "%2B");
			System.out.println(ss3);
			String ss2 = URLDecoder.decode(ss3, "utf-8");
			System.out.println(ss2);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
