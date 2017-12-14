package com.test.cost;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

public class DocumentDemo {
	
	
	public static void main(String[] args) {
		SAXReader reader = new SAXReader();
		Document document = reader.getDocumentFactory().createDocument();
		Element element = document.getRootElement();
		
		String xmlStr = "<root><name>marry</name><max>yunnn</max></root>";
		try {
			Document parseText = DocumentHelper.parseText(xmlStr);
			System.out.println(parseText.getName());
			System.out.println(parseText.asXML());
		} catch (DocumentException e) {
			e.printStackTrace();
		}
		
		try {
			Document documen = reader.read(new InputStreamReader(
					new FileInputStream(new File("d:/tmp.txt")), "UTF-8"));
			String asXML = documen.asXML();
			System.out.println(asXML);
			System.out.println();
			
			Document read = reader.read(new FileInputStream(new File(
					"d:/tmp.txt")));
			System.out.println(read.asXML());
			System.out.println();
			
			Document documtnt1 = reader.read(new BufferedReader(new InputStreamReader(
					new FileInputStream(new File("d:\\tmp.txt")), "UTF-8")));
			System.out.println(documtnt1.asXML());
			
			PrintWriter pw = new PrintWriter(new OutputStreamWriter(
					new FileOutputStream(new File("d:\\tmp.txt")), "UTF-8"),true);
			
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}
}
