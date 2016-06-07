package com.library.dao;

import java.util.List;

import com.library.bean.Ticket;

/**
 * @author Administrator
 * 罚款记录接口类
 */
public interface TicketDao {

	/**
	 * 添加一条罚款记录
	 * @param ticket
	 * @return
	 */
	public boolean addTicket(Ticket ticket);
	
	/**
	 * 查询罚款记录
	 * @param sql
	 * @return
	 */
	public List<Ticket> selectTickets(String sql);
}
