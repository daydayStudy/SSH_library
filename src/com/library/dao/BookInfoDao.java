package com.library.dao;

import java.util.List;

import com.library.bean.BookInfo;

/**
 * @author Administrator
 * 图书信息接口类
 */
public interface BookInfoDao {

	/**
	 * 查询图书
	 * @param sql
	 * @return
	 */
	public List<BookInfo> seleBookInfos(String sql);
	
	/**
	 * 删除图书,isDelete设置为1
	 * @param isbn
	 * @return
	 */
	public boolean deleteBook(String isbn);
	
	/**
	 * 修改图书
	 * @param bookInfo
	 * @return
	 */
	public boolean updateBook(BookInfo bookInfo);
	
	/**
	 * 添加一本图书
	 * @param bookInfo
	 * @return
	 */
	public boolean addBook(BookInfo bookInfo);
}
