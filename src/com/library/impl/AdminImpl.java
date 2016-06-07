package com.library.impl;

import java.util.ArrayList;
import java.util.List;







import oracle.net.aso.p;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.library.bean.Admin;
import com.library.bean.BookInfo;
import com.library.bean.HibernateSessionFactory;
import com.library.dao.AdminDao;
import com.library.dao.CommonDao;

/**
 * @author Administrator
 * 管理员业务逻辑类
 */
public class AdminImpl implements CommonDao,AdminDao {

	private Session session = null;
	private Transaction tran = null;
	
	@Override
	public boolean update(Admin admin) {
		session = HibernateSessionFactory.getSession();
		tran = session.beginTransaction();
		
		try {
			if(admin != null) {
				session.update(admin);
				tran.commit();
				return true;
			}
			
		} catch (HibernateException e) {
			e.printStackTrace();
		}finally {
			HibernateSessionFactory.closeSession();
		}
		
		return false;
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
			String sql = "from Admin as a where a.admindid=? and a.pwd=?";
			Query query = session.createQuery(sql);
			query.setParameter(0, id);
			query.setParameter(1, pwd);
			
			List result = query.list();
			if(result.size()>0) {
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
