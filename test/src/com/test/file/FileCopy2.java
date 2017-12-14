package com.test.file;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

public class FileCopy2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		long start = System.currentTimeMillis();
		try {
			File file = new File("E:/software/UltraEdit.zip");
			FileInputStream fileInputStream = new FileInputStream(file);
			InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream, "UTF-8");
			BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
			
			FileOutputStream fileOutputStream = new FileOutputStream(new File(
					"E:/software/UltraEdit.zip_copy.zip"));			
			//fileOutputStream.write(24);
			//fileOutputStream.write(new byte[10]);
			/*int i = 0;
			while((i= fileInputStream.read()) != -1) {
				fileOutputStream.write(i);
			}*/
			/*String str = "";
			while((str = bufferedReader.readLine()) != null){
				fileOutputStream.write(str.getBytes());
			}*/
			
			OutputStreamWriter outputStreamWriter = new OutputStreamWriter(fileOutputStream, "UTF-8");
			/*String str = "";
			while((str = bufferedReader.readLine()) != null){
				outputStreamWriter.write(str);
			}*/
			
			PrintWriter printWriter = new PrintWriter(outputStreamWriter, true);
			String str = "";
			while((str = bufferedReader.readLine()) != null){
				//printWriter.write(str);
				printWriter.print(str);
			}
			fileOutputStream.flush();
			bufferedReader.close();
			fileOutputStream.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		long end = System.currentTimeMillis();
		
		System.out.println("ºÄÊ± £º " + (end - start) + "ms");
		
	}

}
