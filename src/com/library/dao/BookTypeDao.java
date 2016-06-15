package com.library.dao;

import java.util.List;

import com.library.bean.BookType;

/**
 * @author Administrator
 * ͼ�����ӿ���
 */
public interface BookTypeDao {

	/**
	 * ���ͼ�����
	 * @param bookType
	 * @return
	 */
	public boolean addType(BookType bookType);
	
	/**
	 * ���idɾ�������Ϣ��isDelete����Ϊ1
	 * @param typeId
	 * @return
	 */
	public boolean deleteType(int typeId);
	
	/**
	 * ��ѯ�����Ϣ
	 * @param sql
	 * @return
	 */
	public List<BookType> selectType(String sql);
	
	/**
	 * ����ͼ�����
	 * @param bookType
	 * @return
	 */
	public boolean updateType(BookType bookType);
	public BookType get(int typeId);
	
}
