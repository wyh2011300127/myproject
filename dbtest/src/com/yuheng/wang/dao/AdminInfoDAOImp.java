package com.yuheng.wang.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import com.yuheng.wang.dao.base.AdminInfoDAO;
import com.yuheng.wang.dto.AdminInfo;
import com.yuheng.wang.util.DateUtil;
import com.yuheng.wang.util.JDBCUtil;


public class AdminInfoDAOImp implements AdminInfoDAO{
	private Connection conn = null;
	private Statement st = null;
	PreparedStatement ps = null;
	private ResultSet rs = null;
	
	@Override
	public AdminInfo get(String id) throws Exception{
		conn = JDBCUtil.getConnection();
		String sql = "select * from admin_info where admin_id = " + id;
		st = conn.createStatement();
		rs = st.executeQuery(sql);
		
		AdminInfo adminInfo = new AdminInfo();
		while (rs.next()) {// 判断是否还有下一个数据
			int adminId = rs.getInt("admin_id");
			String adminCode = rs.getString("admin_code");
			String password = rs.getString("password");
			String name = rs.getString("name");
			String telephone = rs.getString("telephone");
			String email = rs.getString("email");
			String enrollDate = rs.getString("enrolldate");
			
			adminInfo.setAdminId(adminId);
			adminInfo.setAdminCode(adminCode);
			adminInfo.setName(name);
			adminInfo.setPassword(password);
			adminInfo.setEmail(email);
			adminInfo.setEnrollDate(enrollDate);
			adminInfo.setTelephone(telephone);
		}
		JDBCUtil.close();
		return adminInfo;
	}

	public static void main(String[] args) {
		
	}

	@Override
	public void insert(AdminInfo adminInfo) throws Exception {
		String sql = "insert into admin_info values (ADMIN_SEQ.NEXTVAL, ?, ?, ?, ?, ?, ?) ";
		conn = JDBCUtil.getConnection();
		ps = conn.prepareStatement(sql);
		ps.setString(1, adminInfo.getAdminCode());
		ps.setString(2, adminInfo.getPassword());
		ps.setString(3, adminInfo.getName());
		ps.setString(4, adminInfo.getTelephone());
		ps.setString(5, adminInfo.getEmail());
		ps.setString(6, adminInfo.getEnrollDate());
		int i = ps.executeUpdate();

		System.out.println("i:" + i);
	}
}














