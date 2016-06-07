package com.library.dao;

import java.util.List;

import com.library.bean.Reader;

/**
 * @author Administrator
 * 图书会员接口类
 */
public interface ReaderDao {

	/**
	 * 注册会员
	 * @param reader
	 * @return
	 */
	public boolean addReader(Reader reader);
	
	/**
	 * 根据id删除会员， isDelete=1
	 * @param readerId
	 * @return
	 */
	public boolean deleteReader(int readerId);
	
	/**
	 * 根据id修改会员信息
	 * @param readerId 会员编号
	 * @param reader 
	 * @return
	 */
	public boolean updateReader(Reader reader);
	
	/**
	 * 查询会员信息
	 * @param sql
	 * @return
	 */
	public List<Reader> selectReaders(String sql);
	
	/**
	 * 根据会员id查询会员信息
	 * @param readerId
	 * @return
	 *//*
	public Reader selectById(int readerId);
	
	*//**
	 * 根据会员姓名进行模糊查询
	 * @param name 
	 * @return
	 *//*
	public List<Reader> selectByName(String name);*/
}
