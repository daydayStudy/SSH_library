package com.library.dao;

import java.util.List;

import com.library.bean.Borrow;

/**
 * @author Administrator
 * 图书借阅记录接口类
 */
public interface BorrowDao {

	/**
	 * 删除借阅记录, isDelete设置为1
	 * @param borrowId
	 * @return
	 */
	public boolean deleteBorrow(int borrowId);
	
	/**
	 * 修改借阅记录
	 * @param borrow
	 * @return
	 */
	public boolean updateBorrow(Borrow borrow);
	
	/**
	 * 查询借阅记录
	 * @param sql
	 * @return
	 */
	public List<Borrow> selectBorrows(String sql);
	
	/**
	 * 插入一条借阅记录
	 * @param borrow
	 * @return
	 */
	public boolean addBorrow(Borrow borrow);
}
