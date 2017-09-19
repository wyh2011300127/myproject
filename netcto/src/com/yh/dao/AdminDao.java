package com.yh.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.yh.dao.common.BaseDaoSupport;
import com.yh.dto.AdminInfo;

/**
 * AdminInfoDao²ã
 * @author wangyuheng
 *
 */
@Repository("adminDao")
public class AdminDao extends BaseDaoSupport{
	
	public void save(AdminInfo adminInfo){
		this.getHibernateTemplate().save(adminInfo);
	}
	
	public void delete(AdminInfo adminInfo) {
		this.getHibernateTemplate().delete(adminInfo);
	}
	
	public void get(String id) {
		this.getHibernateTemplate().get(this.getClass().getName(), id);
	}
	
	@SuppressWarnings("unchecked")
	public AdminInfo queryByAdminCode( String adminCode ){
		List<AdminInfo> find = (List<AdminInfo>) this.getHibernateTemplate().find(
				"from AdminInfo admin where admin.adminCode = ? " , adminCode);
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



