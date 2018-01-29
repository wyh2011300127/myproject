package com.yh.dao.common;

import java.io.Serializable;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

/**
 * dao����� ��ȡsessionFactory
 * 
 * @author Administrator
 * 
 */
@Repository("baseDaoSupport")
public class BaseDaoSupport extends HibernateDaoSupport {
	/**
	 * ΪBaseDaoSupportע��sessionFactory
	 * 
	 * @param sessionFactory
	 */
	@Resource(name = "sessionFactory")
	public void setMySessionFactory(SessionFactory sessionFactory) {
		super.setSessionFactory(sessionFactory);
	}

	/**
	 * �������
	 * 
	 * @param entity
	 */
	public <T> void save(T entity) {
		this.getHibernateTemplate().save(entity);
	}

	/**
	 * ���¶���
	 * 
	 * @param entity
	 */
	public <T> void update(T entity) {
		this.getHibernateTemplate().update(entity);
	}

	/**
	 * ɾ������
	 * 
	 * @param entity
	 */
	public <T> void delete(T entity) {
		this.getHibernateTemplate().delete(entity);
	}

	/**
	 * ����ID��ȡ����
	 * 
	 * @param entityClass
	 * @param id
	 * @return
	 */
	public <T> T findById(Class<T> entityClass, Serializable id) {
		return (T) this.getHibernateTemplate().get(entityClass, id);
	}

	/**
	 * ����hql��ȡΨһ�Ķ���
	 * 
	 * @param hql
	 * @param params
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public <T> T getUniqueResult(String hql, Object... params) {
		Query query = this.getSession().createQuery(hql);
		for (int i = 0; i < params.length; i++) {
			query.setParameter(i, params[i]);
		}
		return (T) query.uniqueResult();
	}

}
