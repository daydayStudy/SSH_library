package com.library.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.library.bean.BookInfo;
import com.library.bean.BookType;
import com.library.bean.HibernateSessionFactory;
import com.library.bean.PageBean;
import com.library.bean.Reader;
import com.library.dao.CommonDao;
import com.library.dao.ReaderDao;

/**
 * @author Administrator
 * Í¼ï¿½ï¿½ï¿½Ô±Òµï¿½ï¿½ï¿½ß¼ï¿½ï¿½ï¿½
 */
public class ReaderImpl implements CommonDao,ReaderDao {

	private Session session = null;
	private Transaction tran = null;
	@Resource
	private PageImpl pageImpl = null;

	@Override
	public boolean addReader(Reader reader) {
		try {
			session = HibernateSessionFactory.getSession();
			tran = session.beginTransaction();
			if(reader != null) {
				reader.setIsdelete(0);
				session.save(reader);
				tran.commit();
				return true;
			}

		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			HibernateSessionFactory.closeSession();
		}

		return false;
	}

	@Override
	public boolean deleteReader(int readerId) {
		try {
			session = HibernateSessionFactory.getSession();
			tran = session.beginTransaction();
			
			String sql = "from Reader as r where r.readerid=? and r.isdelete=?";
			Query query = session.createQuery(sql);
			query.setParameter(0, readerId);
			query.setParameter(1, 0);
			List result = query.list();
			if(result.size()>0) {
				for(Iterator it=result.iterator(); it.hasNext();) {
					Reader reader = (Reader) it.next();
					reader.setIsdelete(1);
					session.update(reader);
					tran.commit();
					return true;
				}
			}
		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			HibernateSessionFactory.closeSession();
		}

		return false;
	}

	@Override
	public boolean updateReader(Reader reader) {
		try {
			session = HibernateSessionFactory.getSession();
			tran = session.beginTransaction();
			
			if(reader != null) {
				session.update(reader);
				tran.commit();
				return true;
			}
		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			HibernateSessionFactory.closeSession();
		}
		
		return false;
	}

	@Override
	public List<Reader> selectReaders(String sql) {
		List<Reader> list = null;

		try {
			session = HibernateSessionFactory.getSession();
			list = new ArrayList<Reader>();
			list = session.createQuery(sql).list();

		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			HibernateSessionFactory.closeSession();
		}

		return list;
	}

	@Override
	public List<BookInfo> selectBooks(String sql) {
		List<BookInfo> list = null;

		try {
			session = HibernateSessionFactory.getSession();
			list = new ArrayList<BookInfo>();
			list = session.createQuery(sql).list();

		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			HibernateSessionFactory.closeSession();
		}

		return list;
	}

	@Override
	public boolean login(int id, String pwd) {

		try {
			session = HibernateSessionFactory.getSession();
			String sql = "from Reader as a where a.readerid=? and a.pwd=?";
			Query query = session.createQuery(sql);
			query.setParameter(0, id);
			query.setParameter(1, pwd);

			List result = query.list();
			if(result.size() > 0) {
				return true;
			}
		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			HibernateSessionFactory.closeSession();
		}

		return false;
	}
	
	public Reader getuser(int readerid){
		try {
			session = HibernateSessionFactory.getSession();
			
			String sql = "from Reader as r where r.readerid=?";
			Query query = session.createQuery(sql);
			query.setParameter(0, readerid);
			List result = query.list();
			if(result.size()>0) {
				for(Iterator it=result.iterator(); it.hasNext();) {
					Reader reader = (Reader) it.next();
					return reader;
				}
			}
		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			HibernateSessionFactory.closeSession();
		}

		return null;
	}
	
	 /**
	  * ï¿½ï¿½Ò³
	 * @param pageSize
	 * @param page
	 * @return
	 */
	public PageBean getPageBean(int pageSize, int page)
	    {
	        PageBean pageBean = new PageBean();
	        
	        String hql = "from Reader as r where r.isdelete=0";
	        int allRows = pageImpl.getAllCount(hql);
	        int totalPage = pageBean.getTotalPages(pageSize, allRows);
	        int currentPage = pageBean.getCurPage(page);
	        int offset = pageBean.getCurrentPageOffset(pageSize, currentPage);
	        List<Reader> list = pageImpl.queryByHibernate(hql, offset, pageSize);
	        
	        System.out.println("ï¿½ï¿½Ò³ï¿½ï¿½="+totalPage);
	        
	        pageBean.setList(list);
	        pageBean.setAllRows(allRows);
	        pageBean.setCurrentPage(currentPage);
	        pageBean.setTotalPage(totalPage);
	        
	        return pageBean;
	    }
	
	 /**
	  * ·ÖÒ³
	 * @param pageSize
	 * @param page
	 * @return
	 */
	public PageBean getReaderPageBean(int pageSize, int page,String readerid)
	    {
	        PageBean pageBean = new PageBean();
	        
	        String hql = "from Reader as r where r.isdelete=0 and r.readerid like '%"+readerid+"%'";
	        int allRows = pageImpl.getAllCount(hql);
	        int totalPage = pageBean.getTotalPages(pageSize, allRows);
	        int currentPage = pageBean.getCurPage(page);
	        int offset = pageBean.getCurrentPageOffset(pageSize, currentPage);
	        List<Reader> list = pageImpl.queryByHibernate(hql, offset, pageSize);
	        
	        System.out.println("×ÜÒ³Êý="+totalPage);
	        
	        pageBean.setList(list);
	        pageBean.setAllRows(allRows);
	        pageBean.setCurrentPage(currentPage);
	        pageBean.setTotalPage(totalPage);
	        
	        return pageBean;
	    }

}
