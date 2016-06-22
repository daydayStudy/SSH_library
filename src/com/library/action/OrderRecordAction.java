package com.library.action;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.library.bean.BookInfo;
import com.library.bean.Order;
import com.library.bean.PageBean;
import com.library.bean.Reader;
import com.library.impl.OrderImpl;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class OrderRecordAction extends ActionSupport {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private OrderImpl orderImpl = new OrderImpl();
	private int page;
	private String method;
	private String id;
	private String readerID;
	private String borrowdate;
	private String booktype;
	private String bookname;
	private String bookISBN;
	private String orderamount;
	
	public String getReaderID() {
		return readerID;
	}
	public void setReaderID(String readerID) {
		this.readerID = readerID;
	}
	public String getBorrowdate() {
		return borrowdate;
	}
	public void setBorrowdate(String borrowdate) {
		this.borrowdate = borrowdate;
	}
	public String getBooktype() {
		return booktype;
	}
	public void setBooktype(String booktype) {
		this.booktype = booktype;
	}
	public String getBookname() {
		return bookname;
	}
	public void setBookname(String bookname) {
		this.bookname = bookname;
	}
	public String getBookISBN() {
		return bookISBN;
	}
	public void setBookISBN(String bookISBN) {
		this.bookISBN = bookISBN;
	}
	public String getOrderamount() {
		return orderamount;
	}
	public void setOrderamount(String orderamount) {
		this.orderamount = orderamount;
	}
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public String getMethod() {
		return method;
	}
	public void setMethod(String method) {
		this.method = method;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
	@Override
	public String execute() throws Exception {
		pageInfo();
		return SUCCESS;
	}

	private void pageInfo() {
		ActionContext context=ActionContext.getContext();
		String readerId = context.getSession().get("loginName").toString();
		int id2 = Integer.parseInt(readerId);
		PageBean pageBean = orderImpl.getPageBean(id2, 11, page);
		System.out.println("page="+page);
		HttpServletRequest request = ServletActionContext.getRequest();
		request.setAttribute("orderinfo", pageBean);
	}
	
	public String  addRecord() {
		Order order = new Order();
		
		order.setAmount(Integer.parseInt(orderamount));
		
		BookInfo bookInfo = new BookInfo();
		bookInfo.setIsbn(bookISBN);
		order.setBookInfo(bookInfo);
		
		order.setIsfinish(0);
		
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Date date;
		try {
			date = format.parse(borrowdate);
			order.setOrderdate(date);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		Reader reader = new Reader();
		reader.setReaderid(Integer.parseInt(readerID));
		order.setReader(reader);
		
		orderImpl.addOrder(order);
		pageInfo();
		
		return SUCCESS;
	}
}
