package com.library.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import oracle.net.aso.b;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.library.bean.BookInfo;
import com.library.bean.BookManagerBean;
import com.library.bean.HibernateSessionFactory;
import com.library.bean.SelectBookBean;
import com.library.util.JUtils;


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
	
	/**
	 * 分页（图书信息管理页面）
	 * @param hql
	 * @param offset
	 * @param pageSize
	 * @return
	 */
	public List<BookManagerBean> queryBookManagerInfo(String hql, int offset, int pageSize) {
		session = HibernateSessionFactory.getSession();
		List<BookManagerBean> result = new ArrayList<>();
		
		try {
			transaction = session.beginTransaction();
			query = session.createQuery(hql).setFirstResult(offset)
						.setMaxResults(pageSize);
			List list = query.list();
			
			for(Iterator it=list.iterator();it.hasNext();) {
				BookManagerBean bean = new BookManagerBean();
				Object[] obj = (Object[]) it.next();
				
				bean.setIsbn(obj[0].toString());
				bean.setBookname(obj[1].toString());
				bean.setTypename(obj[2].toString());
				String str = obj[3].toString();
				if(JUtils.changeToNum(str)) {
					bean.setAmount(Integer.parseInt(str));
				}else {
					bean.setAmount(0);
				}
				
				result.add(bean);
			}
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
	
	/**
	 * 分页（图书查询页面）
	 * @param hql
	 * @param offset
	 * @param pageSize
	 * @return
	 */
	public List<SelectBookBean> queryBookInfo(String hql, int offset, int pageSize) {
		session = HibernateSessionFactory.getSession();
		List<SelectBookBean> result = new ArrayList<SelectBookBean>();
		
		try {
			transaction = session.beginTransaction();
			query = session.createQuery(hql).setFirstResult(offset)
						.setMaxResults(pageSize);
			List list = query.list();
			
			for(Iterator it=list.iterator();it.hasNext();) {
				SelectBookBean bean = new SelectBookBean();
				String str = "";
				Object[] obj = (Object[]) it.next();
				
				bean.setBookname(obj[0].toString());
				bean.setTypename(obj[1].toString());
				if(obj[2] == null) {
					bean.setPublisher("");
				}else {
					bean.setPublisher(obj[2].toString());
				}
				
				if(obj[3] == null) {
					bean.setWriter("");
				}else {
					bean.setWriter(obj[3].toString());
				}
				
				if(obj[4] == null) {
					bean.setTranslator("");
				}else {
					bean.setTranslator(obj[4].toString());
				}
				
				str = obj[5].toString();
				if(JUtils.changeToNum(str)) {
					bean.setAmount(Integer.parseInt(str));
				}else {
					bean.setAmount(0);
				}
				bean.setIsbn(obj[6].toString());
				
				result.add(bean);
			}
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
