package com.library.dao;

import java.util.List;

import com.library.bean.BookInfo;

/**
 * @author Administrator
 * ͨ�ýӿ�
 */
public interface CommonDao {

	/**
	 * ��ѯͼ��
	 * @param sql
	 * @return
	 */
	public List<BookInfo> selectBooks(String sql);
	
	/**
	 * ��¼ 
	 * @param id
	 * @param pwd
	 * @return
	 */
	public boolean login(int id, String pwd);
	
	/**
	 * ����ͼ�����ƽ���ģ����ѯ
	 * @param name
	 * @return
	 *//*
	public List<BookInfo> selectByName(String name);
	
	*//**
	 * ��������ѯͼ��
	 * @param typeName
	 * @return
	 *//*
	public List<BookInfo> selectByType(String typeName);*/
}
