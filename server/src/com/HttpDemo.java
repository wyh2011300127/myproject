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
		
		//�ж��������Ƿ����Դ�άϵͳ��ip��ַ  
	    String ip = request.getRemoteHost();  
	    System.out.println("IP:" + ip);
	    // ��ȡ�յ��ı���  
	    BufferedReader reader = request.getReader();  
	    String line = "";  
        StringBuffer inputString = new StringBuffer();  
        while ((line = reader.readLine()) != null) {  
        	inputString.append(line);  
        }
        System.out.println("����˽��ܵı��ģ�" + inputString.toString());
          
       //���б�Ҫ�������ڱ���������������֤�ͼ��ܵĲ���  
       //������ȡ���ı��ģ�����ip��ַ��������֤�����ܵȵ����ж������ĵķ������Ƿ���Ȩ��  
        
       //���������֤�ϸ����������Ĳ���װ�䷵�صı���  
   
       // Ҫ���صı���  
       StringBuffer resultBuffer = new StringBuffer();  
       resultBuffer.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");  
       resultBuffer.append("<report_data>");  
       resultBuffer.append("<respon_req>953947334</respon_req>");  
       resultBuffer.append("<respon_time>20120402113943</respon_time>");  
       resultBuffer.append("<result>");  
       resultBuffer.append("<id>0000</id>");  
       resultBuffer.append("<comment>�ɹ�</comment>");  
       resultBuffer.append("</result>");  
       resultBuffer.append("<items>");  
       resultBuffer.append("<item>");  
       resultBuffer.append("<county>������</county>");  
       resultBuffer.append("<company>��ͨ</company>");  
       resultBuffer.append("<speciality>��·</speciality>");  
       resultBuffer.append("<personnel>���Ӻ�</personnel>");  
       resultBuffer.append("<begin_time>20120301000000</begin_time>");  
       resultBuffer.append("<end_time>20120331235959</end_time>");  
       resultBuffer.append("<plan_quantity>50</plan_quantity>");  
       resultBuffer.append("<checkout_quantity>40</checkout_quantity>");  
       resultBuffer.append("<patrol_rate>0.80</patrol_rate>");  
       resultBuffer.append("</item>");  
       //......  
       //......  
       //......  
       //ѭ����װ��Ӧ�ı���  
        
       resultBuffer.append("</items>");  
       resultBuffer.append("</report_data>");  
       System.out.println("����˷��͵ı��ģ�" + resultBuffer);
       
       // ���÷��ͱ��ĵĸ�ʽ  
       response.setContentType("text/xml");  
       response.setCharacterEncoding("UTF-8");  
   
       PrintWriter out = response.getWriter();  
       out.println(resultBuffer.toString());  
       out.flush();  
       out.close();  
	}

	public void init() throws ServletException {
		System.out.println(">>>>>>>>>>>>>>>>>>>>>>>��ʼ��Servlet : HttpDemo");
	}

	public void destroy() {
		super.destroy(); 
		System.out.println(">>>>>>>>>>>>>>>>>>>>>>>����Servlet : HttpDemo");
	}
	
}
