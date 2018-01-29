package com.yh.dao;

import org.springframework.stereotype.Repository;

import com.yh.dao.common.BaseDaoSupport;
import com.yh.dto.AdminInfo;

/**
 * AdminInfoDao²ã
 * 
 * @author wangyuheng
 * 
 */
@Repository("adminDao")
public class AdminDao extends BaseDaoSupport {

	public void save(AdminInfo adminInfo) {
		// this.getHibernateTemplate().save(adminInfo);
		super.save(adminInfo);
	}

	public void delete(AdminInfo adminInfo) {
		// this.getHibernateTemplate().delete(adminInfo);
		super.delete(adminInfo);
	}

	public AdminInfo get(String id) {
		// this.getHibernateTemplate().get(this.getClass().getName(), id);
		return super.findById(AdminInfo.class, id);
	}

	public AdminInfo queryByAdminCode(String adminCode) throws Exception {
		String hql = "from AdminInfo admin where admin.adminCode = '"
				+ adminCode + "' ";
		return (AdminInfo) super.getUniqueResult(hql);
	}

}
