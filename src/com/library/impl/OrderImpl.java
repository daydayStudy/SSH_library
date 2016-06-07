package com.library.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.library.bean.HibernateSessionFactory;
import com.library.bean.Order;
import com.library.dao.OrderDao;

/**
 * @author Administrator
 * 预定业务逻辑类
 */
public class OrderImpl implements OrderDao {

	private Session session = null;
	private Transaction tran = null;
	
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

}
