package com.yh.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.yh.dao.common.BaseDaoSupport;
import com.yh.dto.AdminInfo;

/**
 * AdminInfoDao≤„
 * @author wangyuheng
 *
 */
@Repository("adminDao")
public class AdminDao extends BaseDaoSupport{
	
	/**
	 * ±£¥ÊAdminInfo
	 * @param adminInfo
	 */
	public void saveAdmin(AdminInfo adminInfo){
		this.getHibernateTemplate().save(adminInfo);
	}
	
	@SuppressWarnings("unchecked")
	public AdminInfo queryByAdminCode( String adminCode ){
		List<AdminInfo> find = (List<AdminInfo>) this.getHibernateTemplate().find(
				"from AdminInfo admin where admin.adminCode = ? " , adminCode);
		/*for(AdminInfo adminInfo : find){
			System.out.println(adminInfo);
		}*/
		if( find != null && find.size() > 0){
			for(AdminInfo adminInfo : find ){
				if(adminInfo == null ){
					continue;
				}
				return adminInfo;
			}
		}
		return null;
	}
	
	
	
}



