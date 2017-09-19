package com.yh.dao.common;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;
/**
 * dao�����
 * ��ȡsessionFactory
 * @author Administrator
 *
 */
@Repository("baseDaoSupport")
public class BaseDaoSupport extends HibernateDaoSupport{
	/**
	 * ΪBaseDaoSupportע��sessionFactory
	 * @param sessionFactory
	 */
	@Resource(name="sessionFactory")
	public void setMySessionFactory(SessionFactory sessionFactory){
		super.setSessionFactory(sessionFactory);
	}
}
