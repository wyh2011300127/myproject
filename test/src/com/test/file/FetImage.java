package com.test.file;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * @˵�� �������ȡͼƬ������
 * @author ����ǿ
 * @version 1.0
 * @since
 */
public class FetImage {
	/**
	 * ����
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		String url = "http://www.baidu.com/img/baidu_sylogo1.gif";
		byte[] btImg = getImageFromNetByUrl(url);
		if (null != btImg && btImg.length > 0) {
			System.out.println("��ȡ����" + btImg.length + " �ֽ�");
			String fileName = "�ٶ�.gif";
			writeImageToDisk(btImg, fileName);
		} else {
			System.out.println("û�дӸ����ӻ������");
		}
	}

	/**
	 * ��ͼƬд�뵽����
	 * 
	 * @param img
	 *            ͼƬ������
	 * @param fileName
	 *            �ļ�����ʱ������
	 */
	public static void writeImageToDisk(byte[] img, String fileName) {
		try {
			File file = new File("C:\\" + fileName);
			FileOutputStream fops = new FileOutputStream(file);
			fops.write(img);
			fops.flush();
			fops.close();
			System.out.println("ͼƬ�Ѿ�д�뵽C��");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * ���ݵ�ַ������ݵ��ֽ���
	 * 
	 * @param strUrl
	 *            �������ӵ�ַ
	 * @return
	 */
	public static byte[] getImageFromNetByUrl(String strUrl) {
		try {
			URL url = new URL(strUrl);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");
			conn.setConnectTimeout(5 * 1000);
			InputStream inStream = conn.getInputStream();// ͨ����������ȡͼƬ����
			byte[] btImg = readInputStream(inStream);// �õ�ͼƬ�Ķ���������
			return btImg;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * ���������л�ȡ����
	 * 
	 * @param inStream
	 *            ������
	 * @return
	 * @throws Exception
	 */
	public static byte[] readInputStream(InputStream inStream) throws Exception {
		ByteArrayOutputStream outStream = new ByteArrayOutputStream();
		byte[] buffer = new byte[1024];
		int len = 0;
		while ((len = inStream.read(buffer)) != -1) {
			outStream.write(buffer, 0, len);
		}
		inStream.close();
		return outStream.toByteArray();
	}
}
