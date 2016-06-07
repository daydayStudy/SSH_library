package com.library.dao;

import java.util.List;

import com.library.bean.Stock;

/**
 * @author Administrator
 * 库存接口类
 */
public interface StockDao {

	/**
	 * 增加一条库存记录
	 * @param stock
	 * @return
	 */
	public boolean addStock(Stock stock);
	
	/**
	 * 查询库存信息
	 * @param sql
	 * @return
	 */
	public List<Stock> selectStocks(String sql);
	
	/**
	 * 修改库存
	 * @param stock
	 * @return
	 */
	public boolean updateStock(Stock stock);
}
