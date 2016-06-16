package com.library.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.library.bean.BorrowRecordBean;
import com.library.bean.HibernateSessionFactory;
import com.library.bean.Order;
import com.library.bean.OrderRecordBean;
import com.library.bean.PageBean;
import com.library.dao.OrderDao;

/**
 * @author Administrator
 * Ԥ��ҵ���߼���
 */
public class OrderImpl implements OrderDao {

	private Session session = null;
	private Transaction tran = null;
	private PageImpl pageImpl = new PageImpl();
	
	@Override
	public boolean addOrder(Order order) {
		try {
			session = HibernateSessionFactory.getSession();
			tran = session.beginTransaction();
			if(order != null) {
				session.save(order);
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
	public boolean dealOrder(int orderId) {
		try {
			session = HibernateSessionFactory.getSession();
			tran = session.beginTransaction();
			
			String sql = "from Order as r where r.orderid=? and r.isfinish=?";
			Query query = session.createQuery(sql);
			query.setParameter(0, orderId);
			query.setParameter(1, 0);
			List result = query.list();
			if(result.size()>0) {
				for(Iterator it=result.iterator(); it.hasNext();) {
					Order b = (Order) it.next();
					b.setIsfinish(1);
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
	public boolean updateOrder(Order order) {
		try {
			session = HibernateSessionFactory.getSession();
			tran = session.beginTransaction();
			if(order != null) {
				session.update(order);
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
	public List<Order> selectOrders(String sql) {
		List<Order> list = null;

		try {
			session = HibernateSessionFactory.getSession();
			list = new ArrayList<Order>();
			list = session.createQuery(sql).list();

		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			HibernateSessionFactory.closeSession();
		}

		return list;
	}
	
	@SuppressWarnings("unchecked")
	public PageBean getPageBean(int id,int pageSize, int page) {
		PageBean pageBean = new PageBean();

		String hql = "select o.reader.readerid,o.bookInfo.bookname,o.orderdate,o.amount,s.amount from Order as o,Stock as s  "
				+ " where s.bookInfo.isbn=o.bookInfo.isbn and o.reader.readerid="+id+"order by o.orderid desc";
		int allRows = pageImpl.getAllCount(hql);
		int totalPage = pageBean.getTotalPages(pageSize, allRows);
		int currentPage = pageBean.getCurPage(page);
		int offset = pageBean.getCurrentPageOffset(pageSize, currentPage);
		List<OrderRecordBean> list = pageImpl.queryOrderRecordInfo(hql, offset, pageSize);


		pageBean.setList(list);
		pageBean.setAllRows(allRows);
		pageBean.setCurrentPage(currentPage);
		pageBean.setTotalPage(totalPage);

		return pageBean;
	}

}
