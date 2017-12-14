package com.test.file;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

public class FileInput {

	/**
     * 获取字节流
     * @param url
     * @return
     */
    private String getStream(String url){
        //获取字节流
        InputStream in = null;
        String result = "";
        try {
            in = new URL(url).openStream();
            int tmp;
            while((tmp = in.read()) != -1){
                result += (char)tmp;
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        //输出字节流
        return result;
    }
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		 String URL = "http://www.baidu.com";
		 FileInput test = new FileInput();
	     System.out.println(test.getStream(URL));
	}
	
}
