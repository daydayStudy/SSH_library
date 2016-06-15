package com.library.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.library.bean.HibernateSessionFactory;
import com.library.bean.Reader;
import com.library.bean.Stock;
import com.library.dao.StockDao;

/**
 * @author Administrator
 * ���ҵ���߼���
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
	
	public Stock getStock(String ISBN){
		try {
			session = HibernateSessionFactory.getSession();
			
			String sql = "from Stock as r where r.bookInfo.isbn=?";
			Query query = session.createQuery(sql);
			query.setParameter(0, ISBN);
			List result = query.list();
			if(result.size()>0) {
				for(Iterator it=result.iterator(); it.hasNext();) {
					Stock stock = (Stock) it.next();
					return stock;
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
