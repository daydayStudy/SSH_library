package com.library.bean;

import java.util.Date;

/**
 * Order entity. @author MyEclipse Persistence Tools
 */

public class Order implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int orderid;
	private Reader reader;
	private BookInfo bookInfo;
	private int amount;
	private Date orderdate;
	private int isfinish;

	// Constructors

	/** default constructor */
	public Order() {
	}

	/** minimal constructor */
	public Order(Reader reader, BookInfo bookInfo, int amount,
			Date orderdate) {
		this.reader = reader;
		this.bookInfo = bookInfo;
		this.amount = amount;
		this.orderdate = orderdate;
	}

	/** full constructor */
	public Order(Reader reader, BookInfo bookInfo, int amount,
			Date orderdate, int isfinish) {
		this.reader = reader;
		this.bookInfo = bookInfo;
		this.amount = amount;
		this.orderdate = orderdate;
		this.isfinish = isfinish;
	}

	// Property accessors

	public int getOrderid() {
		return this.orderid;
	}

	public void setOrderid(int orderid) {
		this.orderid = orderid;
	}

	public Reader getReader() {
		return this.reader;
	}

	public void setReader(Reader reader) {
		this.reader = reader;
	}

	public BookInfo getBookInfo() {
		return this.bookInfo;
	}

	public void setBookInfo(BookInfo bookInfo) {
		this.bookInfo = bookInfo;
	}

	public int getAmount() {
		return this.amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public Date getOrderdate() {
		return this.orderdate;
	}

	public void setOrderdate(Date orderdate) {
		this.orderdate = orderdate;
	}

	public int getIsfinish() {
		return this.isfinish;
	}

	public void setIsfinish(int isfinish) {
		this.isfinish = isfinish;
	}

}