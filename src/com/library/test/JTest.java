package com.library.test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import junit.framework.TestCase;
import oracle.net.aso.p;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.library.bean.Admin;
import com.library.bean.BookInfo;
import com.library.bean.BookManagerBean;
import com.library.bean.BorrowBookBean;
import com.library.bean.BorrowRecordBean;
import com.library.bean.HibernateSessionFactory;
import com.library.bean.OrderRecordBean;
import com.library.bean.PageBean;
import com.library.bean.Reader;
import com.library.impl.BookInfoImpl;
import com.library.impl.PageImpl;
import com.library.impl.ReaderImpl;

public class JTest extends TestCase {
	Session session = null;
	Transaction transaction = null;
	Query query = null;

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

	public void testSelectReaders() {
		ReaderImpl readerImpl = new ReaderImpl();
		String hql = "from Reader as r where r.isdelete=0 and r.readerid like '%"+130+"%'";
		List<Reader> readers = readerImpl.selectReaders(hql);
		for(Iterator it = readers.iterator();it.hasNext();) {
			Reader reader = (Reader) it.next();
			System.out.println(reader.getReaderid());
		}
	}

	public void testselectBookInfo() {
		BookInfoImpl impl = new BookInfoImpl();
		List<BorrowBookBean> beans = impl.selectBook("a");
		for(Iterator it = beans.iterator();it.hasNext();) {
			BorrowBookBean reader = (BorrowBookBean) it.next();
			System.out.println(reader.getAmount());
		}
		
	}
	
	public void testChangeDate() throws ParseException {
		String dateString = "2017-7-14";
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Date date = format.parse(dateString);
		System.out.println(date);
	}

	
	public void testRecord() {
		PageImpl pageImpl = new PageImpl();
		String hql = "select b.reader.readerid,b.bookInfo.bookname,b.borrowdate,b.backdate from Borrow as b where b.reader.readerid="+"1304001";
		List<BorrowRecordBean> beans = pageImpl.queryBorrowRecordInfo(hql, 0, 8);
		for(Iterator<BorrowRecordBean> iterator=beans.iterator();iterator.hasNext();) {
			BorrowRecordBean bean = iterator.next();
			System.out.println(bean.getBorrowDate());
			System.out.println(bean.getBackDate());
			System.out.println(bean.getReaderid());
			System.out.println(bean.getBookname());
			System.out.println(bean.getDays());
		}
	}
	
	public void testCount() {
		PageImpl pageImpl = new PageImpl();
		String hql = "select b.reader.readerid,b.bookInfo.bookname,b.borrowdate,b.backdate from Borrow as b where b.reader.readerid="+"1304001";
		int allRows = pageImpl.getAllCount(hql);
		System.out.println(allRows);
	}
	
	public void testOrder() {
		PageImpl pageImpl = new PageImpl();
//		String hql = "select o.reader.readerid,o.bookInfo.bookname,o.orderdate,o.amount,s.amount from Order as o,Stock as s where s.bookInfo.isbn=o.bookInfo.isbn";
		String hql = "select o.reader.readerid,o.bookInfo.bookname,o.orderdate,o.amount,s.amount from Order as o,Stock as s  "
				+ " where s.bookInfo.isbn=o.bookInfo.isbn and o.reader.readerid="+1304001+"order by o.orderid desc";
		List<OrderRecordBean> beans = pageImpl.queryOrderRecordInfo(hql, 0, 8);
		for(Iterator<OrderRecordBean> iterator=beans.iterator();iterator.hasNext();) {
			OrderRecordBean bean = iterator.next();
			System.out.println(bean.getReaderid().toString());
		}
	}
	
	public void testSle() {
//		String hql = "select b.bookType.typeid from BookInfo as b where b.isbn="+"13020110";
//		session = HibernateSessionFactory.getSession();
//		Query query = session.createQuery(hql);
//		List list = query.list();
//		if(list.size()> 0) {
//			int typeid =  (int) list.get(0);
//			System.out.println(typeid);
//		}
		String hql = "select b.finemoney from BookType as b where b.typeid="+1;
		session = HibernateSessionFactory.getSession();
		Query query = session.createQuery(hql);
		List list = query.list();
		if(list.size()>0) {
			float fines = (float) list.get(0);
			System.out.println(fines);
		}
	}
	
}
