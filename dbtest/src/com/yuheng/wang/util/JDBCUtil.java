package com.yuheng.wang.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class JDBCUtil {
	//orcl为oracle数据库中的数据库名，localhost表示连接本机的oracle数据库 ，1521为连接的端口号   
	private static	String url = "jdbc:oracle:thin:@localhost:1521:orcl";
	private static	String username = "wangyh";
	private static	String password = "123456";
	
	public static Connection conn = null;
	public static PreparedStatement ps = null;
	public static ResultSet rs = null;
	/**
	 * 初始化
	 */
	public static void init(){
		try {
			// 初始化驱动包
			Class.forName("oracle.jdbc.driver.OracleDriver");
			// 根据数据库连接字符，名称，密码给conn赋值
			conn = DriverManager.getConnection(url, username, password);
		} catch (Exception e) {
			System.out.println("初始化连接异常！");
			e.printStackTrace();
		}
	}
	/**
	 * 获取一个数据库连接
	 * @return
	 */
	public static Connection getConnection(){
		System.out.println("获取一个数据库连接：conn = " + conn);
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
