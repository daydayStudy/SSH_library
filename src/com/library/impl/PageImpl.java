package com.library.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.library.bean.HibernateSessionFactory;


/**
 * @author Administrator
 *分页
 */
public class PageImpl {

	Session session = null;
	Transaction transaction = null;
	Query query = null;
	
	/**
	 * 获得全部记录
	 * @param hql
	 * @return
	 */
	public int getAllCount(String hql) {
		session = HibernateSessionFactory.getSession();
		int counts = 0;
		
		try {
			transaction = session.beginTransaction();
			query = session.createQuery(hql);
			counts = query.list().size();
			transaction.commit();
			
		} catch (Exception e) {
			if(transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		} finally {
			query = null;
			HibernateSessionFactory.closeSession();
		}
		
		return counts;
	}
	
	/**
	 * 分页
	 * @param hql
	 * @param offset
	 * @param pageSize
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List queryByHibernate(String hql, int offset, int pageSize) {
		session = HibernateSessionFactory.getSession();
		List result = null;
		
		try {
			transaction = session.beginTransaction();
			query = session.createQuery(hql).setFirstResult(offset)
						.setMaxResults(pageSize);
			result = query.list();
			transaction.commit();
			
		} catch (Exception e) {
			if(transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		} finally {
			query = null;
			HibernateSessionFactory.closeSession();
		}
		
		return result;
	}
}
