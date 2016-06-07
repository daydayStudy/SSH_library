package com.library.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.library.bean.BookInfo;
import com.library.bean.HibernateSessionFactory;
import com.library.dao.BookInfoDao;

/**
 * @author Administrator
 * 图书业务逻辑类
 */
public class BookInfoImpl implements BookInfoDao  {

	private Session session = null;
	private Transaction tran = null;
	
	@Override
	public List<BookInfo> seleBookInfos(String sql) {
		List<BookInfo> list = null;

		try {
			session = HibernateSessionFactory.getSession();
			list = new ArrayList<BookInfo>();
			list = session.createQuery(sql).list();

		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			HibernateSessionFactory.closeSession();
		}

		return list;
	}

	@Override
	public boolean deleteBook(String isbn) {
		try {
			session = HibernateSessionFactory.getSession();
			tran = session.beginTransaction();
			
			String sql = "from BookInfo as r where r.isbn=? and r.isdelete=?";
			Query query = session.createQuery(sql);
			query.setParameter(0, isbn);
			query.setParameter(1, 0);
			List result = query.list();
			if(result.size()>0) {
				for(Iterator it=result.iterator(); it.hasNext();) {
					BookInfo book = (BookInfo) it.next();
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
	public boolean updateBook(BookInfo bookInfo) {
		try {
			session = HibernateSessionFactory.getSession();
			tran = session.beginTransaction();
			if(bookInfo != null) {
				session.update(bookInfo);
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
	public boolean addBook(BookInfo bookInfo) {
		try {
			session = HibernateSessionFactory.getSession();
			tran = session.beginTransaction();
			if(bookInfo != null) {
				session.save(bookInfo);
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
