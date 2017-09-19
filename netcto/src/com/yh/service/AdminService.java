package com.yh.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.yh.dao.AdminDao;
import com.yh.dto.AdminInfo;

@Service("adminService")
public class AdminService {
	
	@Resource(name="adminDao")
	private AdminDao adminDao;
	
	public void saveAdminInfo( AdminInfo adminInfo ){
		adminDao.save(adminInfo);
	}
	
	public AdminInfo queryByAdminCode( String adminCode ){
		return adminDao.queryByAdminCode(adminCode);
	}
	
}




