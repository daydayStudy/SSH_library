package com.library.dao;

import java.util.List;

import com.library.bean.BookInfo;

/**
 * @author Administrator
 * 通用接口
 */
public interface CommonDao {

	/**
	 * 查询图书
	 * @param sql
	 * @return
	 */
	public List<BookInfo> selectBooks(String sql);
	
	/**
	 * 登录 
	 * @param id
	 * @param pwd
	 * @return
	 */
	public boolean login(int id, String pwd);
	
	/**
	 * 根据图书名称进行模糊查询
	 * @param name
	 * @return
	 *//*
	public List<BookInfo> selectByName(String name);
	
	*//**
	 * 根据类别查询图书
	 * @param typeName
	 * @return
	 *//*
	public List<BookInfo> selectByType(String typeName);*/
}
