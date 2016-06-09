package com.library.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.library.bean.BookInfo;
import com.library.bean.BookManagerBean;
import com.library.bean.HibernateSessionFactory;
import com.library.bean.PageBean;
import com.library.bean.Reader;
import com.library.dao.BookInfoDao;

/**
 * @author Administrator
 * 图书业务逻辑类
 */
public class BookInfoImpl implements BookInfoDao  {

	private Session session = null;
	private Transaction tran = null;
	@Resource
	private PageImpl pageImpl;

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
			List<BookInfo> result = query.list();
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

	/**
	 * 分页
	 * @param pageSize
	 * @param page
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public PageBean getPageBean(int pageSize, int page) {
		PageBean pageBean = new PageBean();

		String hql = "select b.isbn,b.bookname,t.typename,s.amount from BookInfo as b,BookType as t,"
				+ " Stock as s where b.bookType.typeid=t.typeid and b.isbn=s.bookInfo.isbn and b.isdelete=0";
		int allRows = pageImpl.getAllCount(hql);
		int totalPage = pageBean.getTotalPages(pageSize, allRows);
		int currentPage = pageBean.getCurPage(page);
		int offset = pageBean.getCurrentPageOffset(pageSize, currentPage);
		List<BookManagerBean> list = pageImpl.queryBookManagerInfo(hql, offset, pageSize);

		System.out.println("总页数="+totalPage);

		pageBean.setList(list);
		pageBean.setAllRows(allRows);
		pageBean.setCurrentPage(currentPage);
		pageBean.setTotalPage(totalPage);

		return pageBean;
	}

}
