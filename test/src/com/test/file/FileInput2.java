package com.test.file;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
/**
 * 总结 
 * 在读取网络数据流的时候，可以通过先用InputStream获取字节流、
 * InputStreamReader将字节流转化成字符流、BufferedReader
 * 将字符流以缓存形式输出的方式来快速获取网络数据流。
 * @author wangyuheng
 *
 */
public class FileInput2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			//获取字节流
			InputStream inputStream = new URL("https://www.hao123.com").openStream();
			int read = 0;
			/*while((read = inputStream.read()) != -1){
				System.out.print((char)read);
			}*/
			
			// 获取字符流
			InputStreamReader reader = new InputStreamReader(inputStream,"UTF-8");
			/*while((read = reader.read()) != -1){
				System.out.print((char)read);
			}*/
			
			// 获取字符缓冲流
			String line = null;
			BufferedReader br = new BufferedReader(reader);
			while((line = br.readLine()) != null){
				System.out.print(line);
			}
			
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
