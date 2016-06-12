package com.library.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.library.bean.BookType;
import com.library.bean.HibernateSessionFactory;
import com.library.bean.PageBean;
import com.library.bean.Reader;
import com.library.dao.BookTypeDao;

/**
 * @author Administrator
 * ͼ�����ҵ���߼���
 */
public class BookTypeImpl implements BookTypeDao {

	private Session session = null;
	private Transaction tran = null;
	@Resource
	private PageImpl pageImpl;

	@Override
	public boolean addType(BookType bookType) {
		try {
			session = HibernateSessionFactory.getSession();
			tran = session.beginTransaction();
			if(bookType != null) {
				session.save(bookType);
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
	public boolean deleteType(int typeId) {
		try {
			session = HibernateSessionFactory.getSession();
			tran = session.beginTransaction();

			String sql = "from BookType as r where r.typeid=? and r.isdelete=?";
			Query query = session.createQuery(sql);
			query.setParameter(0, typeId);
			query.setParameter(1, 0);
			List result = query.list();
			if(result.size()>0) {
				for(Iterator it=result.iterator(); it.hasNext();) {
					BookType book = (BookType) it.next();
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
	public List<BookType> selectType(String sql) {
		List<BookType> list = null;

		try {
			session = HibernateSessionFactory.getSession();
			list = new ArrayList<BookType>();
			list = session.createQuery(sql).list();

		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			HibernateSessionFactory.closeSession();
		}

		return list;
	}

	@Override
	public boolean updateType(BookType bookType) {
		try {
			session = HibernateSessionFactory.getSession();
			tran = session.beginTransaction();
			if(bookType != null) {
				session.update(bookType);
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
     * 根据id查询booktype
     * @param typeId
     * @return
     */
    public BookType get(int typeId) {
    	try {
			session = HibernateSessionFactory.getSession();
			
			String sql = "from BookType as r where r.typeid=?";
			Query query = session.createQuery(sql);
			query.setParameter(0, typeId);
			List result = query.list();
			if(result.size()>0) {
				for(Iterator it=result.iterator(); it.hasNext();) {
					BookType book = (BookType) it.next();
					return book;
				}
			}
		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			HibernateSessionFactory.closeSession();
		}

		return null;
    }

	/**
	 * ��ҳ
	 * @param pageSize
	 * @param page
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public PageBean getPageBean(int pageSize, int page){
		PageBean pageBean = new PageBean();

		String hql = "from BookType as b where b.isdelete=0";
		int allRows = pageImpl.getAllCount(hql);
		int totalPage = pageBean.getTotalPages(pageSize, allRows);
		int currentPage = pageBean.getCurPage(page);
		int offset = pageBean.getCurrentPageOffset(pageSize, currentPage);
		List<Reader> list = pageImpl.queryByHibernate(hql, offset, pageSize);

		System.out.println("��ҳ��="+totalPage);

		pageBean.setList(list);
		pageBean.setAllRows(allRows);
		pageBean.setCurrentPage(currentPage);
		pageBean.setTotalPage(totalPage);

		return pageBean;
	}


}
