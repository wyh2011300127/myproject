package com.yh.util;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

public class ResponseUtil {
	
	private static Logger logger = Logger.getLogger(ResponseUtil.class);
	
	public static void readerLoginMsg(String msg , HttpServletResponse response , String result){
		//result 0:login≥…π¶  , 1:login ß∞‹
		response.setContentType("text/html;charset=utf-8");
		Map<String , String> loginMsgMap = new HashMap<String , String>();
		loginMsgMap.put("msg", msg);
		loginMsgMap.put("loginResult", result);
		PrintWriter writer = null ; 
		try {
			writer = response.getWriter();
			writer.write(JSONUtil.object2Json(loginMsgMap));
		} catch (IOException e) {
			e.printStackTrace();
			logger.error("ResponseUtil.readerLoginMsg() error...");
		}finally{
			if (writer != null) {
				writer.close();
			}
		}
		
		
	}
	
	
}






