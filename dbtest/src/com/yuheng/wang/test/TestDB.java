package com.yuheng.wang.test;

import java.util.Date;

import com.yuheng.wang.dto.AdminInfo;
import com.yuheng.wang.service.AdminInfoService;
import com.yuheng.wang.util.DateUtil;

public class TestDB {
	
	private AdminInfoService adminInfoService = new AdminInfoService();
	
	public void insert() {
		AdminInfo adminInfo = new AdminInfo();
		adminInfo.setAdminCode("shuyi");
		adminInfo.setEmail("shuyi@tarena.com.cn");
		adminInfo.setEnrollDate(DateUtil.dateToString(new Date()));
		adminInfo.setName("舒逸");
		adminInfo.setPassword("123");
		adminInfo.setTelephone("18756038022");
		try {
			adminInfoService.insert(adminInfo);
		} catch (Exception e) {
			System.out.println("插入数据异常！");
			e.printStackTrace();
		}
	}

	public void get() {
		String id = "2000";
		try {
			AdminInfo adminInfo = adminInfoService.get(id);
			if (adminInfo != null) {
				System.out.println(adminInfo);
			} else {
				System.out.println("未查到此用户");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	public static void main(String[] args) {
		TestDB testDB = new TestDB();
		//testDB.get();
		testDB.insert();
		
	}
}
