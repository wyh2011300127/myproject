package com.test.file;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class DownloadPicture {
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//String path = "http://ossweb-img.qq.com/images/qtalk/cf_weapon/C0001.png";
		for (int i = 1; i < 30; i++) {
			String path = "http://ossweb-img.qq.com/images/qtalk/cf_weapon/C000" + i + ".png";
			downLoadPicture(path, i);
		}
	}
	/**
	 * 下载图片方法
	 * @param urlPath
	 */
	public static void downLoadPicture(String urlPath, int i) {
		long start = System.currentTimeMillis();
		URL url = null;
		InputStream is = null;
		OutputStream os = null;
		try {
			//构造URL
			url = new URL(urlPath);
			//打开网络连接
			HttpURLConnection http = (HttpURLConnection) url.openConnection();
			http.setDoInput(true);
			http.connect();
			if (http.getResponseCode() == HttpURLConnection.HTTP_OK) {
				// 获取字节流
				is = http.getInputStream();
				byte[] buf = new byte[1024];
				
				File file = new File("E:/down/weapon" + i + ".png");
				int line = 0;
				os = new FileOutputStream(file);
				while ((line = is.read(buf)) != -1) {
					os.write(buf, 0, line);
				}
			} else {
				System.out.println("地址不存在:" + urlPath);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (is != null) {
					is.close();
				}
				if (os != null) {
					os.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		long end = System.currentTimeMillis();
		System.out.println("耗时：" + (end-start) + "ms");
	}
}
