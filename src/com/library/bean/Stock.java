package com.library.bean;


/**
 * Stock entity. @author MyEclipse Persistence Tools
 */

public class Stock implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int stockid;
	private BookInfo bookInfo;
	private int amount;

	// Constructors

	/** default constructor */
	public Stock() {
	}

	/** full constructor */
	public Stock(BookInfo bookInfo, int amount) {
		this.bookInfo = bookInfo;
		this.amount = amount;
	}

	// Property accessors

	public int getStockid() {
		return this.stockid;
	}

	public void setStockid(int stockid) {
		this.stockid = stockid;
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

}