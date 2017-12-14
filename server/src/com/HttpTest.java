package com;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class HttpTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			sendMessage();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void sendMessage() throws Exception {
	    System.out.println("调用servlet开始=================");
	    StringBuffer sendStr = new StringBuffer();
	    sendStr.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
	    sendStr.append("<report_data>");
	    sendStr.append("<request_req>953943547334</request_req>");
	    sendStr.append("<request_time>2012040211394324</request_time>");
	    sendStr.append("<request_param>");
	    sendStr.append("<query_month>201203</query_month>");
	    sendStr.append("</request_param>");
	    sendStr.append("</report_data>");
	    BufferedReader reader = null;
	    try {
	        String strMessage = "";
	        StringBuffer buffer = new StringBuffer();
	        // 接报文的地址
	        URL uploadServlet = new URL(
	               "http://localhost:8080/server/servlet/HttpDemo");
	        HttpURLConnection servletConnection = (HttpURLConnection) uploadServlet
	               .openConnection();
	        // 设置连接参数
	        servletConnection.setRequestMethod("POST");
	        servletConnection.setDoOutput(true);
	        servletConnection.setDoInput(true);
	        servletConnection.setAllowUserInteraction(true);
	        // 开启流，写入XML数据
	        OutputStream output = servletConnection.getOutputStream();
	        System.out.println("发送的报文：");
	        System.out.println(sendStr.toString());
	        output.write(sendStr.toString().getBytes());
	        output.flush();
	        output.close();
	        // 获取返回的数据
	        InputStream inputStream = servletConnection.getInputStream();
	        reader = new BufferedReader(new InputStreamReader(inputStream));
	        while ((strMessage = reader.readLine()) != null) {
	           buffer.append(strMessage);
	        }
	        System.out.println("接收返回值:" + buffer);
	    } catch (java.net.ConnectException e) {
	        throw new Exception();
	    } finally {
	        if (reader != null) {
	           reader.close();
	        }
	    }
	 }
}
