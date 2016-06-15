package com.library.dao;

import java.util.List;

import com.library.bean.BookInfo;
import com.library.bean.BookType;

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
	public BookInfo getBook(String isbn);
	
	/**
	 * ���һ��ͼ��
	 * @param bookInfo
	 * @return
	 */
	public boolean addBook(BookInfo bookInfo);
}
