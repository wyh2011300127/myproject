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
				throw new RuntimeException("Ҫ��ȡ���ļ������ڣ�");
			}
			FileInputStream fileInputStream = new FileInputStream(file);
			int read = 0;
			// ��һ�ֶ�ȡ��ʽ  ����
			/*while ((read = fileInputStream.read()) != -1) {
				System.out.println(read);
			}*/
			
			// �ڶ��ֶ�ȡ��ʽ  �Ͽ�
			/*byte[] buf = new byte[SIZE]; // 5 10 1024ʱ����ܴ�
			while ((read = fileInputStream.read(buf)) != -1) {
				System.out.println(read);
			}*/
			
			// �����ֶ�ȡ��ʽ  ���԰��ֽ�������ָ���ı���ת����Ӧ���ַ���
			//char[] cha = new char[1024];
			InputStreamReader inputStreamReader = new InputStreamReader(
					fileInputStream);
			/*int read2 = 0;
			while ((read2 = inputStreamReader.read()) != -1) { // inputStreamReader.read(cha)
				System.out.println(read2);
				char hh = (char)read2;
				System.out.println(hh);
			}
			char ch = '��';
			int a = ch;
			System.out.println(a);
			*/
			
			//������ ���������ַ���  ���
			BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
			//int read3 = 0;
			// �����ַ�����
			/*while((read3 = bufferedReader.read()) != -1){
				System.out.println(read3);
			}*/
			// ָ���������ַ�����
			/*while((read3 = bufferedReader.read(CHA)) != -1){
				System.out.println(read3);
			}*/
			// ���ж�ȡ
			String str = "";
			while((str = bufferedReader.readLine()) != null){
				System.out.println(str); // �����������
			}
			bufferedReader.close();
		} catch (Exception e) {
			e.printStackTrace();
		} 
		long end = System.currentTimeMillis();
		System.out.println("��ʱ��" + (end - start));
	}

}