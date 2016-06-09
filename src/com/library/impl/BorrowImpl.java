package com.library.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import oracle.net.aso.b;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.library.bean.Borrow;
import com.library.bean.HibernateSessionFactory;
import com.library.dao.BorrowDao;

/**
 * @author Administrator
 * 借阅记录业务逻辑类
 */
public class BorrowImpl implements BorrowDao {

	private Session session = null;
	private Transaction tran = null;
	
	@Override
	public boolean deleteBorrow(int borrowId) {
		try {
			session = HibernateSessionFactory.getSession();
			tran = session.beginTransaction();
			
			String sql = "from Borrow as r where r.borrowid=? and r.isback=?";
			Query query = session.createQuery(sql);
			query.setParameter(0, borrowId);
			query.setParameter(1, 0);
			List result = query.list();
			if(result.size()>0) {
				for(Iterator it=result.iterator(); it.hasNext();) {
					Borrow b = (Borrow) it.next();
					b.setIsback(1);
					session.update(b);
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
	public boolean updateBorrow(Borrow borrow) {
		try {
			session = HibernateSessionFactory.getSession();
			tran = session.beginTransaction();
			if(borrow != null) {
				session.update(borrow);
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
	public List<Borrow> selectBorrows(String sql) {
		List<Borrow> list = null;

		try {
			session = HibernateSessionFactory.getSession();
			list = new ArrayList<Borrow>();
			list = session.createQuery(sql).list();

		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			HibernateSessionFactory.closeSession();
		}

		return list;
	}

	@Override
	public boolean addBorrow(Borrow borrow) {
		try {
			session = HibernateSessionFactory.getSession();
			tran = session.beginTransaction();
			if(borrow != null) {
				session.save(borrow);
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
