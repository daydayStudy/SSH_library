package com.library.dao;

import java.util.List;

import com.library.bean.BookType;

/**
 * @author Administrator
 * 图书类别接口类
 */
public interface BookTypeDao {

	/**
	 * 添加图书类别
	 * @param bookType
	 * @return
	 */
	public boolean addType(BookType bookType);
	
	/**
	 * 根据id删除类别信息，isDelete设置为1
	 * @param typeId
	 * @return
	 */
	public boolean deleteType(int typeId);
	
	/**
	 * 查询类别信息
	 * @param sql
	 * @return
	 */
	public List<BookType> selectType(String sql);
	
	/**
	 * 更新图书类别
	 * @param bookType
	 * @return
	 */
	public boolean updateType(BookType bookType);
}
