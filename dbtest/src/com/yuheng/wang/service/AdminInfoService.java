package com.yuheng.wang.service;

import com.yuheng.wang.dao.AdminInfoDAOImp;
import com.yuheng.wang.dao.base.AdminInfoDAO;
import com.yuheng.wang.dto.AdminInfo;

public class AdminInfoService {

	private AdminInfoDAO adminInfoDAO = new AdminInfoDAOImp();
	
	public AdminInfo get(String id) throws Exception{
		
		return adminInfoDAO.get(id);
		
	}
	
	public void insert(AdminInfo adminInfo) throws Exception {
		adminInfoDAO.insert(adminInfo);
	}
	
}
