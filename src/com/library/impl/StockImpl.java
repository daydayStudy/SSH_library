package com.library.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.library.bean.HibernateSessionFactory;
import com.library.bean.Stock;
import com.library.dao.StockDao;

/**
 * @author Administrator
 * ¿â´æÒµÎñÂß¼­Àà
 */
public class StockImpl implements StockDao {

	private Session session = null;
	private Transaction tran = null;
	
	@Override
	public boolean addStock(Stock stock) {
		try {
			session = HibernateSessionFactory.getSession();
			tran = session.beginTransaction();
			if(stock != null) {
				session.save(stock);
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
	public List<Stock> selectStocks(String sql) {
		List<Stock> list = null;

		try {
			session = HibernateSessionFactory.getSession();
			list = new ArrayList<Stock>();
			list = session.createQuery(sql).list();

		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			HibernateSessionFactory.closeSession();
		}

		return list;
	}

	@Override
	public boolean updateStock(Stock stock) {
		try {
			session = HibernateSessionFactory.getSession();
			tran = session.beginTransaction();
			if(stock != null) {
				session.update(stock);
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

}
