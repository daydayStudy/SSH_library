package com.library.dao;

import java.util.List;

import com.library.bean.Borrow;

/**
 * @author Administrator
 * ͼ����ļ�¼�ӿ���
 */
public interface BorrowDao {

	/**
	 * ɾ����ļ�¼, isDelete����Ϊ1
	 * @param borrowId
	 * @return
	 */
	public boolean deleteBorrow(int borrowId);
	
	/**
	 * �޸Ľ��ļ�¼
	 * @param borrow
	 * @return
	 */
	public boolean updateBorrow(Borrow borrow);
	
	/**
	 * ��ѯ���ļ�¼
	 * @param sql
	 * @return
	 */
	public List<Borrow> selectBorrows(String sql);
	
	/**
	 * ����һ�����ļ�¼
	 * @param borrow
	 * @return
	 */
	public Borrow getBorrow(String ISBN);
	public boolean addBorrow(Borrow borrow);
}
