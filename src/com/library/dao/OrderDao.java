package com.library.dao;

import java.util.List;

import com.library.bean.Order;

/**
 * @author Administrator
 * 预定图书接口类
 */
public interface OrderDao {

	/**
	 * 添加一条预定记录
	 * @param order
	 * @return
	 */
	public boolean addOrder(Order order);
	
	/**
	 * 根据id处理预定记录， isFinish设置为1
	 * @param orderId
	 * @return
	 */
	public boolean dealOrder(int orderId);
	
	/**
	 * 修改预定信息
	 * @param order
	 * @return
	 */
	public boolean updateOrder(Order order);
	
	/**
	 * 查询预定记录
	 * @param sql
	 * @return
	 */
	public List<Order> selectOrders(String sql);
}
