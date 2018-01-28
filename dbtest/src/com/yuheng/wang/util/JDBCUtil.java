package com.yuheng.wang.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class JDBCUtil {
	//orclΪoracle���ݿ��е����ݿ�����localhost��ʾ���ӱ�����oracle���ݿ� ��1521Ϊ���ӵĶ˿ں�   
	private static	String url = "jdbc:oracle:thin:@localhost:1521:orcl";
	private static	String username = "wangyh";
	private static	String password = "123456";
	
	public static Connection conn = null;
	public static PreparedStatement ps = null;
	public static ResultSet rs = null;
	/**
	 * ��ʼ��
	 */
	public static void init(){
		try {
			// ��ʼ��������
			Class.forName("oracle.jdbc.driver.OracleDriver");
			// �������ݿ������ַ������ƣ������conn��ֵ
			conn = DriverManager.getConnection(url, username, password);
		} catch (Exception e) {
			System.out.println("��ʼ�������쳣��");
			e.printStackTrace();
		}
	}
	/**
	 * ��ȡһ�����ݿ�����
	 * @return
	 */
	public static Connection getConnection(){
		System.out.println("��ȡһ�����ݿ����ӣ�conn = " + conn);
		if (conn == null) {
			init();
		}
		return conn;
	}
	
	public static void close() {
		try {
			if (conn != null) {
				conn.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		System.out.println(getConnection());
	}
	
}
