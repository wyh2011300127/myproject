package com.test.file;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class FileDemo {
	private static Log log = LogFactory.getLog(FileDemo.class);
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		BufferedReader reader = null;
		PrintWriter pw = null;
		try {
			File file = new File("d:/tmp.txt");
			FileInputStream inputStream = new FileInputStream(file);
			InputStreamReader inputStreamReader = new InputStreamReader(inputStream,"UTF-8");
			reader = new BufferedReader(inputStreamReader);
			
			FileOutputStream outputStream = new FileOutputStream(new File("E:/emp/emp.txt"));
			OutputStreamWriter outputStreamWriter = new OutputStreamWriter(outputStream,"UTF-8");
			pw = new PrintWriter(outputStreamWriter,true);
			
			StringBuffer sb = new StringBuffer();
			String line = null;
			while ((line = reader.readLine()) != null) {
				log.info(line);
				sb.append(line);
				pw.println(line);
			}
			log.info(sb.toString());
			pw.flush();
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			try {
				if(reader != null){
					reader.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
			try {
				if(pw != null){
					pw.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}
		
	}

}
