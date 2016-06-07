package com.library.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.library.bean.BookType;
import com.library.bean.HibernateSessionFactory;
import com.library.dao.BookTypeDao;

/**
 * @author Administrator
 * 图书类别业务逻辑类
 */
public class BookTypeImpl implements BookTypeDao {

	private Session session = null;
	private Transaction tran = null;
	
	@Override
	public boolean addType(BookType bookType) {
		try {
			session = HibernateSessionFactory.getSession();
			tran = session.beginTransaction();
			if(bookType != null) {
				session.save(bookType);
				tran.commit();
				return true;
			}

		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			HibernateSessionFactory.closeSession();
		}

		return false;
	}

	@Override
	public boolean deleteType(int typeId) {
		try {
			session = HibernateSessionFactory.getSession();
			tran = session.beginTransaction();
			
			String sql = "from BookType as r where r.typeid=? and r.isdelete=?";
			Query query = session.createQuery(sql);
			query.setParameter(0, typeId);
			query.setParameter(1, 0);
			List result = query.list();
			if(result.size()>0) {
				for(Iterator it=result.iterator(); it.hasNext();) {
					BookType book = (BookType) it.next();
					book.setIsdelete(1);
					session.update(book);
					tran.commit();
					return true;
				}
			}
		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			HibernateSessionFactory.closeSession();
		}

		return false;
	}

	@Override
	public List<BookType> selectType(String sql) {
		List<BookType> list = null;

		try {
			session = HibernateSessionFactory.getSession();
			list = new ArrayList<BookType>();
			list = session.createQuery(sql).list();

		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			HibernateSessionFactory.closeSession();
		}

		return list;
	}

	@Override
	public boolean updateType(BookType bookType) {
		try {
			session = HibernateSessionFactory.getSession();
			tran = session.beginTransaction();
			if(bookType != null) {
				session.update(bookType);
				tran.commit();
				return true;
			}

		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			HibernateSessionFactory.closeSession();
		}

		return false;
	}

}
