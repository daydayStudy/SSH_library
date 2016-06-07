package com.library.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.library.bean.HibernateSessionFactory;
import com.library.bean.Ticket;
import com.library.dao.TicketDao;

/**
 * @author Administrator
 * 罚款业务逻辑类
 */
public class TicketImpl implements TicketDao {

	private Session session = null;
	private Transaction tran = null;
	
	@Override
	public boolean addTicket(Ticket ticket) {
		try {
			session = HibernateSessionFactory.getSession();
			tran = session.beginTransaction();
			if(ticket != null) {
				session.save(ticket);
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
	public List<Ticket> selectTickets(String sql) {
		List<Ticket> list = null;

		try {
			session = HibernateSessionFactory.getSession();
			list = new ArrayList<Ticket>();
			list = session.createQuery(sql).list();

		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			HibernateSessionFactory.closeSession();
		}

		return list;
	}

}
