package com.library.bean;

import java.util.Date;

/**
 * Borrow entity. @author MyEclipse Persistence Tools
 */

public class Borrow implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int borrowid;
	private Reader reader;
	private BookInfo bookInfo;
	private int isback;
	private Date borrowdate;
	private Date backdate;

	// Constructors

	/** default constructor */
	public Borrow() {
	}

	/** minimal constructor */
	public Borrow(Reader reader, BookInfo bookInfo, Date borrowdate,
			Date backdate) {
		this.reader = reader;
		this.bookInfo = bookInfo;
		this.borrowdate = borrowdate;
		this.backdate = backdate;
	}

	/** full constructor */
	public Borrow(Reader reader, BookInfo bookInfo, int isback,
			Date borrowdate, Date backdate) {
		this.reader = reader;
		this.bookInfo = bookInfo;
		this.isback = isback;
		this.borrowdate = borrowdate;
		this.backdate = backdate;
	}

	// Property accessors

	public int getBorrowid() {
		return this.borrowid;
	}

	public void setBorrowid(int borrowid) {
		this.borrowid = borrowid;
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

	public int getIsback() {
		return this.isback;
	}

	public void setIsback(int isback) {
		this.isback = isback;
	}

	public Date getBorrowdate() {
		return this.borrowdate;
	}

	public void setBorrowdate(Date borrowdate) {
		this.borrowdate = borrowdate;
	}

	public Date getBackdate() {
		return this.backdate;
	}

	public void setBackdate(Date backdate) {
		this.backdate = backdate;
	}

}