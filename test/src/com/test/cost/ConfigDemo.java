package com.test.cost;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

public class ConfigDemo {
	//加载文件的位置
	private static final String systemProperties = "C:/ahb2b/config/system.properties";
	//存放配置信息
	private static Map<String , ResourceBundle> propertiesMap = new HashMap<String , ResourceBundle>();
	
	private static void  generate(){
		SAXReader sax = new SAXReader();
		Document document = sax.getDocumentFactory().createDocument("GBK");
		Element element = document.addElement("ROOT"); //创建根节点
		
		Element REQUEST_METHOD = element.addElement("REQUEST_METHOD");
		REQUEST_METHOD.addAttribute("type", "String");
		REQUEST_METHOD.setText("DeviceInStockSelf");
		
		Element BAT_ID = element.addElement("BAT_ID");
		BAT_ID.addAttribute("type", "String");
		BAT_ID.setText("NET00000000001");
		BAT_ID.addText("12345");
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddhhmmss");
		Date date = new Date();
		Element SEND_TIME = element.addElement("SEND_TIME");
		SEND_TIME.addAttribute("type", "String");
		SEND_TIME.setText(sdf.format(date));
		
		Element DeviceinStock = element.addElement("DeviceinStock");
		Element InGroupId = DeviceinStock.addElement("InGroupId");
		InGroupId.addAttribute("type", "String");
		InGroupId.setText("113052073");
		for(int i=0;i<11;i++) {
			Element IMER_NO = DeviceinStock.addElement("IMER_NO");
			IMER_NO.addAttribute("type", "String");
			IMER_NO.setText(String.valueOf(i));
		}
		
		String asXML = document.asXML();
		System.out.println(asXML);
		
	}
	public static void main(String[] args){
		generate();
	}
	
}
