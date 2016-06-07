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
import com.library.bean.Reader;
import com.library.dao.CommonDao;
import com.library.dao.ReaderDao;

/**
 * @author Administrator
 * 图书会员业务逻辑类
 */
public class ReaderImpl implements CommonDao,ReaderDao {

	private Session session = null;
	private Transaction tran = null;

	@Override
	public boolean addReader(Reader reader) {
		try {
			session = HibernateSessionFactory.getSession();
			tran = session.beginTransaction();
			if(reader != null) {
				session.save(reader);
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
	public boolean deleteReader(int readerId) {
		try {
			session = HibernateSessionFactory.getSession();
			tran = session.beginTransaction();
			
			String sql = "from Reader as r where r.readerid=? and r.isdelete=?";
			Query query = session.createQuery(sql);
			query.setParameter(0, readerId);
			query.setParameter(1, 0);
			List result = query.list();
			if(result.size()>0) {
				for(Iterator it=result.iterator(); it.hasNext();) {
					Reader reader = (Reader) it.next();
					reader.setIsdelete(1);
					session.update(reader);
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
	public boolean updateReader(Reader reader) {
		try {
			session = HibernateSessionFactory.getSession();
			tran = session.beginTransaction();
			
			if(reader != null) {
				session.update(reader);
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
	public List<Reader> selectReaders(String sql) {
		List<Reader> list = null;

		try {
			session = HibernateSessionFactory.getSession();
			list = new ArrayList<Reader>();
			list = session.createQuery(sql).list();

		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			HibernateSessionFactory.closeSession();
		}

		return list;
	}

	@Override
	public List<BookInfo> selectBooks(String sql) {
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
	public boolean login(int id, String pwd) {

		try {
			session = HibernateSessionFactory.getSession();
			String sql = "from Reader as a where a.readerid=? and a.pwd=?";
			Query query = session.createQuery(sql);
			query.setParameter(0, id);
			query.setParameter(1, pwd);

			List result = query.list();
			if(result.size() > 0) {
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
