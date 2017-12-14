package com.test.file;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
/**
 * �ܽ� 
 * �ڶ�ȡ������������ʱ�򣬿���ͨ������InputStream��ȡ�ֽ�����
 * InputStreamReader���ֽ���ת�����ַ�����BufferedReader
 * ���ַ����Ի�����ʽ����ķ�ʽ�����ٻ�ȡ������������
 * @author wangyuheng
 *
 */
public class FileInput2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			//��ȡ�ֽ���
			InputStream inputStream = new URL("https://www.hao123.com").openStream();
			int read = 0;
			/*while((read = inputStream.read()) != -1){
				System.out.print((char)read);
			}*/
			
			// ��ȡ�ַ���
			InputStreamReader reader = new InputStreamReader(inputStream,"UTF-8");
			/*while((read = reader.read()) != -1){
				System.out.print((char)read);
			}*/
			
			// ��ȡ�ַ�������
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
