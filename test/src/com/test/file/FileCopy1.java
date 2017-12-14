package com.test.file;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class FileCopy1 {
	
	private static int SIZE = 1024;
	private static char[] CHA = new char[1024];
	
	public static void main(String[] args) {
		long start = System.currentTimeMillis();
		try {
			File file = new File("E:/software/UltraEdit.zip");
			if (!file.exists()) {
				throw new RuntimeException("要读取的文件不存在！");
			}
			FileInputStream fileInputStream = new FileInputStream(file);
			int read = 0;
			// 第一种读取方式  很慢
			/*while ((read = fileInputStream.read()) != -1) {
				System.out.println(read);
			}*/
			
			// 第二种读取方式  较快
			/*byte[] buf = new byte[SIZE]; // 5 10 1024时间差距很大
			while ((read = fileInputStream.read(buf)) != -1) {
				System.out.println(read);
			}*/
			
			// 第三种读取方式  可以把字节流按照指定的编码转成相应的字符流
			//char[] cha = new char[1024];
			InputStreamReader inputStreamReader = new InputStreamReader(
					fileInputStream);
			/*int read2 = 0;
			while ((read2 = inputStreamReader.read()) != -1) { // inputStreamReader.read(cha)
				System.out.println(read2);
				char hh = (char)read2;
				System.out.println(hh);
			}
			char ch = '你';
			int a = ch;
			System.out.println(a);
			*/
			
			//第四种 缓冲输入字符流  最快
			BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
			//int read3 = 0;
			// 单个字符缓冲
			/*while((read3 = bufferedReader.read()) != -1){
				System.out.println(read3);
			}*/
			// 指定数量的字符缓冲
			/*while((read3 = bufferedReader.read(CHA)) != -1){
				System.out.println(read3);
			}*/
			// 按行读取
			String str = "";
			while((str = bufferedReader.readLine()) != null){
				System.out.println(str); // 打出来并不快
			}
			bufferedReader.close();
		} catch (Exception e) {
			e.printStackTrace();
		} 
		long end = System.currentTimeMillis();
		System.out.println("耗时：" + (end - start));
	}

}