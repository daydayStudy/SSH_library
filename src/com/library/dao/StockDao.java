package com.library.dao;

import java.util.List;

import com.library.bean.BookType;
import com.library.bean.Stock;

/**
 * @author Administrator
 * ���ӿ���
 */
public interface StockDao {

	/**
	 * ����һ������¼
	 * @param stock
	 * @return
	 */
	public boolean addStock(Stock stock);
	
	/**
	 * ��ѯ�����Ϣ
	 * @param sql
	 * @return
	 */
	public List<Stock> selectStocks(String sql);
	public Stock getStock(String ISBN);
	/**
	 * �޸Ŀ��
	 * @param stock
	 * @return
	 */
	public boolean updateStock(Stock stock);
}
