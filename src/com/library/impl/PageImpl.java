package com.library.impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import oracle.net.aso.b;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.library.bean.BookInfo;
import com.library.bean.BookManagerBean;
import com.library.bean.BorrowRecordBean;
import com.library.bean.HibernateSessionFactory;
import com.library.bean.OrderRecordBean;
import com.library.bean.ReturnBookBean;
import com.library.bean.SelectBookBean;
import com.library.util.JUtils;


/**
 * @author Administrator
 *锟斤拷页
 */
public class PageImpl {

	Session session = null;
	Transaction transaction = null;
	Query query = null;
	
	/**
	 * 锟斤拷锟饺拷锟斤拷锟铰�
	 * @param hql
	 * @return
	 */
	public int getAllCount(String hql) {
		session = HibernateSessionFactory.getSession();
		int counts = 0;
		
		try {
			transaction = session.beginTransaction();
			query = session.createQuery(hql);
			counts = query.list().size();
			transaction.commit();
			
		} catch (Exception e) {
			if(transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		} finally {
			query = null;
			HibernateSessionFactory.closeSession();
		}
		
		return counts;
	}
	
	/**
	 * 锟斤拷页
	 * @param hql
	 * @param offset
	 * @param pageSize
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List queryByHibernate(String hql, int offset, int pageSize) {
		session = HibernateSessionFactory.getSession();
		List result = null;
		
		try {
			transaction = session.beginTransaction();
			query = session.createQuery(hql).setFirstResult(offset)
						.setMaxResults(pageSize);
			result = query.list();
			transaction.commit();
			
		} catch (Exception e) {
			if(transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		} finally {
			query = null;
			HibernateSessionFactory.closeSession();
		}
		
		return result;
	}
	
	/**
	 * 锟斤拷页锟斤拷图锟斤拷锟斤拷息锟斤拷锟斤拷页锟芥）
	 * @param hql
	 * @param offset
	 * @param pageSize
	 * @return
	 */
	public List<BookManagerBean> queryBookManagerInfo(String hql, int offset, int pageSize) {
		session = HibernateSessionFactory.getSession();
		List<BookManagerBean> result = new ArrayList<>();
		
		try {
			transaction = session.beginTransaction();
			query = session.createQuery(hql).setFirstResult(offset)
						.setMaxResults(pageSize);
			List list = query.list();
			
			for(Iterator it=list.iterator();it.hasNext();) {
				BookManagerBean bean = new BookManagerBean();
				Object[] obj = (Object[]) it.next();
				
				bean.setIsbn(obj[0].toString());
				bean.setBookname(obj[1].toString());
				bean.setTypename(obj[2].toString());
				String str = obj[3].toString();
				if(JUtils.changeToNum(str)) {
					bean.setAmount(Integer.parseInt(str));
				}else {
					bean.setAmount(0);
				}
				
				result.add(bean);
			}
			transaction.commit();
			
		} catch (Exception e) {
			if(transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		} finally {
			query = null;
			HibernateSessionFactory.closeSession();
		}
		
		return result;
	}
	
	
	public List<ReturnBookBean> queryReturnBookManagerInfo(String hql, int offset, int pageSize) {
		session = HibernateSessionFactory.getSession();
		List<ReturnBookBean> result = new ArrayList<>();
		
		try {
			transaction = session.beginTransaction();
			query = session.createQuery(hql).setFirstResult(offset)
						.setMaxResults(pageSize);
			List list = query.list();
//			isbn,name,bookname,b.isback,borrowdate,backdate,amount,readerid
			for(Iterator it=list.iterator();it.hasNext();) {
				ReturnBookBean bean = new ReturnBookBean();
				Object[] obj = (Object[]) it.next();
				bean.setIsbn(obj[0].toString());
				bean.setName(obj[1].toString());
				bean.setBookname(obj[2].toString());
				int isback = Integer.parseInt(obj[3].toString());
				bean.setIsback(isback);
				
				String string = obj[4].toString();
				String date = string.substring(0, 11);
				bean.setBorrowdate(date);
				
				string = obj[5].toString();
				date = string.substring(0, 11);
				bean.setBackdate(date);
				
				int amount = Integer.parseInt(obj[6].toString());
				bean.setAmount(amount);	
				
				bean.setRederid(obj[7].toString());
				bean.setBorrowid(obj[8].toString());
				
				result.add(bean);
			}
			transaction.commit();
			
		} catch (Exception e) {
			if(transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		} finally {
			query = null;
			HibernateSessionFactory.closeSession();
		}
		
		return result;
	}
	/**
	 * 锟斤拷页锟斤拷图锟斤拷锟窖筹拷妫�
	 * @param hql
	 * @param offset
	 * @param pageSize
	 * @return
	 */
	public List<SelectBookBean> queryBookInfo(String hql, int offset, int pageSize) {
		session = HibernateSessionFactory.getSession();
		List<SelectBookBean> result = new ArrayList<SelectBookBean>();
		
		try {
			transaction = session.beginTransaction();
			query = session.createQuery(hql).setFirstResult(offset)
						.setMaxResults(pageSize);
			List list = query.list();
			
			for(Iterator it=list.iterator();it.hasNext();) {
				SelectBookBean bean = new SelectBookBean();
				String str = "";
				Object[] obj = (Object[]) it.next();
				
				bean.setBookname(obj[0].toString());
				bean.setTypename(obj[1].toString());
				if(obj[2] == null) {
					bean.setPublisher("");
				}else {
					bean.setPublisher(obj[2].toString());
				}
				
				if(obj[3] == null) {
					bean.setWriter("");
				}else {
					bean.setWriter(obj[3].toString());
				}
				
				if(obj[4] == null) {
					bean.setTranslator("");
				}else {
					bean.setTranslator(obj[4].toString());
				}
				
				str = obj[5].toString();
				if(JUtils.changeToNum(str)) {
					bean.setAmount(Integer.parseInt(str));
				}else {
					bean.setAmount(0);
				}
				bean.setIsbn(obj[6].toString());
				
				result.add(bean);
			}
			transaction.commit();
			
		} catch (Exception e) {
			if(transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		} finally {
			query = null;
			HibernateSessionFactory.closeSession();
		}
		
		return result;
	}
	
	//select b.reader.name,b.bookInfo.bookname,b.borrowdate,b.backdate from Borrow as b where b.reader.readerid="+id
	/**
	 * 图书借阅记录信息分页
	 * @param hql
	 * @param offset
	 * @param pageSize
	 * @return
	 */
	public List<BorrowRecordBean> queryBorrowRecordInfo(String hql, int offset, int pageSize) {
		session = HibernateSessionFactory.getSession();
		List<BorrowRecordBean> result = new ArrayList<BorrowRecordBean>();
		
		try {
			transaction = session.beginTransaction();
			query = session.createQuery(hql).setFirstResult(offset)
						.setMaxResults(pageSize);
			List list = query.list();
			
			for(Iterator it=list.iterator();it.hasNext();) {
				BorrowRecordBean bean = new BorrowRecordBean();
				Object[] obj = (Object[]) it.next();
				
				bean.setReaderid(obj[0].toString());
				bean.setBookname(obj[1].toString());
				
				String str1 = obj[2].toString();
				String date = str1.substring(0, 11);
				bean.setBorrowDate(date);
				
				String str2 = obj[3].toString();
				date = str2.substring(0, 11);
				bean.setBackDate(date);
				
				SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
				//当前日期
				String currentDate = format.format(new Date());
				Date now = format.parse(currentDate);
				Date backDate = format.parse(str2);
				int days = (int) ((backDate.getTime()-now.getTime())/86400000);
				
				bean.setDays(days);
				
				result.add(bean);
			}
			transaction.commit();
			
		} catch (Exception e) {
			if(transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		} finally {
			query = null;
			HibernateSessionFactory.closeSession();
		}
		
		return result;
	}
	
	/**
	 * 预定记录信息分页
	 * @param hql
	 * @param offset
	 * @param pageSize
	 * @return
	 */
	public List<OrderRecordBean> queryOrderRecordInfo(String hql, int offset, int pageSize) {
		session = HibernateSessionFactory.getSession();
		List<OrderRecordBean> result = new ArrayList<OrderRecordBean>();
		
		try {
			transaction = session.beginTransaction();
			query = session.createQuery(hql).setFirstResult(offset)
						.setMaxResults(pageSize);
			List list = query.list();
			// readerid,bookname,orderdate,o.amount,s.amount
			for(Iterator it=list.iterator();it.hasNext();) {
				OrderRecordBean bean = new OrderRecordBean();
				Object[] obj = (Object[]) it.next();
				
				bean.setReaderid(obj[0].toString());
				bean.setBookname(obj[1].toString());
				
				String str1 = obj[2].toString();
				String date = str1.substring(0, 11);
				bean.setOrderdate(date);
				
				int amount = Integer.parseInt(obj[3].toString());
				bean.setAmount(amount);
				
				int stock = Integer.parseInt(obj[4].toString());
				bean.setStocks(stock);
				
				result.add(bean);
			}
			transaction.commit();
			
		} catch (Exception e) {
			if(transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		} finally {
			query = null;
			HibernateSessionFactory.closeSession();
		}
		
		return result;
	}
}
