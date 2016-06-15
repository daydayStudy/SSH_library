package com.library.dao;

import java.util.List;

import com.library.bean.BookType;
import com.library.bean.Reader;

/**
 * @author Administrator
 * ͼ���Ա�ӿ���
 */
public interface ReaderDao {

	/**
	 * ע���Ա
	 * @param reader
	 * @return
	 */
	public boolean addReader(Reader reader);
	
	/**
	 * ���idɾ���Ա�� isDelete=1
	 * @param readerId
	 * @return
	 */
	public boolean deleteReader(int readerId);
	
	/**
	 * ���id�޸Ļ�Ա��Ϣ
	 * @param readerId ��Ա���
	 * @param reader 
	 * @return
	 */
	public boolean updateReader(Reader reader);
	
	/**
	 * ��ѯ��Ա��Ϣ
	 * @param sql
	 * @return
	 */
	public List<Reader> selectReaders(String sql);
	public Reader getuser(int readerid);
	/**
	 * ��ݻ�Աid��ѯ��Ա��Ϣ
	 * @param readerId
	 * @return
	 *//*
	public Reader selectById(int readerId);
	
	*//**
	 * ��ݻ�Ա�������ģ���ѯ
	 * @param name 
	 * @return
	 *//*
	public List<Reader> selectByName(String name);*/
}
