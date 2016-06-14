package com.library.test;

import java.util.Iterator;
import java.util.List;

import junit.framework.TestCase;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.library.bean.Admin;
import com.library.bean.BookInfo;
import com.library.bean.BookManagerBean;
import com.library.bean.HibernateSessionFactory;
import com.library.bean.PageBean;
import com.library.bean.Reader;
import com.library.impl.BookInfoImpl;
import com.library.impl.PageImpl;

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
	
	public void testPage() {
		PageBean pageBean = new PageBean();
		PageImpl pageImpl = new PageImpl();

		String hql = "select b.isbn,b.bookname,t.typename,s.amount from BookInfo as b,BookType as t,"
				+ " Stock as s where b.bookType.typeid=t.typeid and b.isbn=s.bookInfo.isbn and b.isdelete=0";
		int allRows = pageImpl.getAllCount(hql);
		int currentPage = pageBean.getCurPage(1);
		int offset = pageBean.getCurrentPageOffset(8, currentPage);
		List list = pageImpl.queryBookManagerInfo(hql, offset, 8);
		
		for(Iterator iterator= list.iterator();iterator.hasNext();) {
			BookManagerBean bean = (BookManagerBean) iterator.next();
			System.out.println(bean.getIsbn());
		}
	}
	
	public void testDeleteBook() {
		BookInfoImpl impl = new BookInfoImpl();
		impl.deleteBook("13020112");
	}
	
	public void testSelect() {
		String name = "a";
		String hql = "select b.bookname,t.typename,b.publisher,b.writer,b.translator,s.amount from BookInfo as b,BookType as t,"
				+ " Stock as s where b.bookType.typeid=t.typeid and b.isbn=s.bookInfo.isbn and b.isdelete=0 and b.bookname like '%"+name+"%'";
		Session session = HibernateSessionFactory.getSession();
		Query query = session.createQuery(hql);
		List list = query.list();
		if(list.size() > 0) 
			System.out.println("lalala");
	
	}

	
	public void testBOOK() {
	}
}
