package com.library.dao;

import java.util.List;

import com.library.bean.Ticket;

/**
 * @author Administrator
 * �����¼�ӿ���
 */
public interface TicketDao {

	/**
	 * ���һ�������¼
	 * @param ticket
	 * @return
	 */
	public boolean addTicket(Ticket ticket);
	
	/**
	 * ��ѯ�����¼
	 * @param sql
	 * @return
	 */
	public List<Ticket> selectTickets(String sql);
}
