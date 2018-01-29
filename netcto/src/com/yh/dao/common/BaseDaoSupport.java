package com.yh.dao.common;

import java.io.Serializable;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

/**
 * dao层基类 获取sessionFactory
 * 
 * @author Administrator
 * 
 */
@Repository("baseDaoSupport")
public class BaseDaoSupport extends HibernateDaoSupport {
	/**
	 * 为BaseDaoSupport注入sessionFactory
	 * 
	 * @param sessionFactory
	 */
	@Resource(name = "sessionFactory")
	public void setMySessionFactory(SessionFactory sessionFactory) {
		super.setSessionFactory(sessionFactory);
	}

	/**
	 * 保存对象
	 * 
	 * @param entity
	 */
	public <T> void save(T entity) {
		this.getHibernateTemplate().save(entity);
	}

	/**
	 * 更新对象
	 * 
	 * @param entity
	 */
	public <T> void update(T entity) {
		this.getHibernateTemplate().update(entity);
	}

	/**
	 * 删除对象
	 * 
	 * @param entity
	 */
	public <T> void delete(T entity) {
		this.getHibernateTemplate().delete(entity);
	}

	/**
	 * 根据ID获取对象
	 * 
	 * @param entityClass
	 * @param id
	 * @return
	 */
	public <T> T findById(Class<T> entityClass, Serializable id) {
		return (T) this.getHibernateTemplate().get(entityClass, id);
	}

	/**
	 * 根据hql获取唯一的对象
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
