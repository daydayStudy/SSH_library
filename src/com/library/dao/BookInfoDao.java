package com.library.dao;

import java.util.List;

import com.library.bean.BookInfo;

/**
 * @author Administrator
 * ͼ����Ϣ�ӿ���
 */
public interface BookInfoDao {

	/**
	 * ��ѯͼ��
	 * @param sql
	 * @return
	 */
	public List<BookInfo> seleBookInfos(String sql);
	
	/**
	 * ɾ��ͼ��,isDelete����Ϊ1
	 * @param isbn
	 * @return
	 */
	public boolean deleteBook(String isbn);
	
	/**
	 * �޸�ͼ��
	 * @param bookInfo
	 * @return
	 */
	public boolean updateBook(BookInfo bookInfo);
	
	/**
	 * ���һ��ͼ��
	 * @param bookInfo
	 * @return
	 */
	public boolean addBook(BookInfo bookInfo);
}
