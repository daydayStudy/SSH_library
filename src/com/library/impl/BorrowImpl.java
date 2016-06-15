package com.library.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.annotation.Resource;

import oracle.net.aso.b;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.library.bean.BookManagerBean;
import com.library.bean.Borrow;
import com.library.bean.BorrowBookBean;
import com.library.bean.BorrowRecordBean;
import com.library.bean.HibernateSessionFactory;
import com.library.bean.PageBean;
import com.library.bean.Stock;
import com.library.dao.BorrowDao;

/**
 * @author Administrator
 * ï¿½ï¿½ï¿½Ä¼ï¿½Â¼Òµï¿½ï¿½ï¿½ß¼ï¿½ï¿½ï¿½
 */
public class BorrowImpl implements BorrowDao {

	private Session session = null;
	private Transaction tran = null;
	private PageImpl pageImpl = new PageImpl();
	
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

	public Borrow getBorrow(String ISBN){
		try {
			session = HibernateSessionFactory.getSession();
			
			String sql = "from Borrow as r where r.bookInfo.isbn=?";
			Query query = session.createQuery(sql);
			query.setParameter(0, ISBN);
			List result = query.list();
			if(result.size()>0) {
				for(Iterator it=result.iterator(); it.hasNext();) {
					Borrow borrow = (Borrow) it.next();
					return borrow;
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
	
	/**
	 * ½èÔÄ¼ÇÂ¼·ÖÒ³
	 * @param pageSize
	 * @param page
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public PageBean getPageBean(int id,int pageSize, int page) {
		PageBean pageBean = new PageBean();

		String hql = "select b.reader.readerid,b.bookInfo.bookname,b.borrowdate,b.backdate from Borrow as b where b.reader.readerid="+id;
		int allRows = pageImpl.getAllCount(hql);
		int totalPage = pageBean.getTotalPages(pageSize, allRows);
		int currentPage = pageBean.getCurPage(page);
		int offset = pageBean.getCurrentPageOffset(pageSize, currentPage);
		List<BorrowRecordBean> list = pageImpl.queryBorrowRecordInfo(hql, offset, pageSize);


		pageBean.setList(list);
		pageBean.setAllRows(allRows);
		pageBean.setCurrentPage(currentPage);
		pageBean.setTotalPage(totalPage);

		return pageBean;
	}

}
