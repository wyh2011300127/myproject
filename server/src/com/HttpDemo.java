package com;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HttpDemo extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request, response);
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		//判断请求报文是否来自代维系统的ip地址  
	    String ip = request.getRemoteHost();  
	    System.out.println("IP:" + ip);
	    // 获取收到的报文  
	    BufferedReader reader = request.getReader();  
	    String line = "";  
        StringBuffer inputString = new StringBuffer();  
        while ((line = reader.readLine()) != null) {  
        	inputString.append(line);  
        }
        System.out.println("服务端接受的报文：" + inputString.toString());
          
       //如有必要，可以在报文中增加其他验证和加密的参数  
       //解析获取到的报文，根据ip地址、其他验证、加密等等来判断请求报文的服务器是否有权限  
        
       //如果请求验证合格，则根据请求的参数装配返回的报文  
   
       // 要返回的报文  
       StringBuffer resultBuffer = new StringBuffer();  
       resultBuffer.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");  
       resultBuffer.append("<report_data>");  
       resultBuffer.append("<respon_req>953947334</respon_req>");  
       resultBuffer.append("<respon_time>20120402113943</respon_time>");  
       resultBuffer.append("<result>");  
       resultBuffer.append("<id>0000</id>");  
       resultBuffer.append("<comment>成功</comment>");  
       resultBuffer.append("</result>");  
       resultBuffer.append("<items>");  
       resultBuffer.append("<item>");  
       resultBuffer.append("<county>长治县</county>");  
       resultBuffer.append("<company>铁通</company>");  
       resultBuffer.append("<speciality>线路</speciality>");  
       resultBuffer.append("<personnel>王加和</personnel>");  
       resultBuffer.append("<begin_time>20120301000000</begin_time>");  
       resultBuffer.append("<end_time>20120331235959</end_time>");  
       resultBuffer.append("<plan_quantity>50</plan_quantity>");  
       resultBuffer.append("<checkout_quantity>40</checkout_quantity>");  
       resultBuffer.append("<patrol_rate>0.80</patrol_rate>");  
       resultBuffer.append("</item>");  
       //......  
       //......  
       //......  
       //循环组装响应的报文  
        
       resultBuffer.append("</items>");  
       resultBuffer.append("</report_data>");  
       System.out.println("服务端发送的报文：" + resultBuffer);
       
       // 设置发送报文的格式  
       response.setContentType("text/xml");  
       response.setCharacterEncoding("UTF-8");  
   
       PrintWriter out = response.getWriter();  
       out.println(resultBuffer.toString());  
       out.flush();  
       out.close();  
	}

	public void init() throws ServletException {
		System.out.println(">>>>>>>>>>>>>>>>>>>>>>>初始化Servlet : HttpDemo");
	}

	public void destroy() {
		super.destroy(); 
		System.out.println(">>>>>>>>>>>>>>>>>>>>>>>销毁Servlet : HttpDemo");
	}
	
}
