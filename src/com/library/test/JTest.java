package com.library.test;

import junit.framework.TestCase;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.library.bean.Admin;
import com.library.bean.HibernateSessionFactory;
import com.library.bean.Reader;

public class JTest extends TestCase {
	
	public void testInsertReader() {
		Session session = HibernateSessionFactory.getSession();
		Transaction tran = session.beginTransaction();
		
		Reader reader = new Reader();
		reader.setName("lala");
		reader.setPwd("123456");
		session.saveOrUpdate(reader);
		
		tran.commit();
		HibernateSessionFactory.closeSession();
	}
	
	public void testInsertAdmin() {
		Session session = HibernateSessionFactory.getSession();
		Transaction tran = session.beginTransaction();
		
		Admin admin = new Admin();
		admin.setAdmindid(123456);
		admin.setName("lala");
		admin.setPwd("123456");
		session.saveOrUpdate(admin);
		
		tran.commit();
		HibernateSessionFactory.closeSession();
	}

}
