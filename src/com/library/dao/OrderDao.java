package com.library.dao;

import java.util.List;

import com.library.bean.Order;

/**
 * @author Administrator
 * Ԥ��ͼ��ӿ���
 */
public interface OrderDao {

	/**
	 * ���һ��Ԥ����¼
	 * @param order
	 * @return
	 */
	public boolean addOrder(Order order);
	
	/**
	 * ����id����Ԥ����¼�� isFinish����Ϊ1
	 * @param orderId
	 * @return
	 */
	public boolean dealOrder(int orderId);
	
	/**
	 * �޸�Ԥ����Ϣ
	 * @param order
	 * @return
	 */
	public boolean updateOrder(Order order);
	
	/**
	 * ��ѯԤ����¼
	 * @param sql
	 * @return
	 */
	public List<Order> selectOrders(String sql);
}
