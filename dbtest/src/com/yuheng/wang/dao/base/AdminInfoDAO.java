package com.yuheng.wang.dao.base;

import com.yuheng.wang.dto.AdminInfo;

public interface AdminInfoDAO {

	public AdminInfo get(String sqlString) throws Exception;
	
	public void insert(AdminInfo adminInfo) throws Exception;
	
}
