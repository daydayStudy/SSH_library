package com.library.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;









import oracle.net.aso.p;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.library.bean.Admin;
import com.library.bean.BookInfo;
import com.library.bean.HibernateSessionFactory;
import com.library.bean.Reader;
import com.library.dao.AdminDao;
import com.library.dao.CommonDao;

/**
 * @author Administrator
 * ����Աҵ���߼���
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

	
	public Admin getadmin(int admindid){
		try {
			session = HibernateSessionFactory.getSession();
			
			String sql = "from Admin as r where r.admindid=?";
			Query query = session.createQuery(sql);
			query.setParameter(0, admindid);
			List result = query.list();
			if(result.size()>0) {
				for(Iterator it=result.iterator(); it.hasNext();) {
					Admin admin = (Admin) it.next();
					return admin;
				}
			}
		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			HibernateSessionFactory.closeSession();
		}

		return null;
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
