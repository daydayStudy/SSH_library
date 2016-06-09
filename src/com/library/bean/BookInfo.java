package com.library.bean;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * BookInfo entity. @author MyEclipse Persistence Tools
 */

public class BookInfo implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String isbn;
	private BookType bookType;
	private String bookname;
	private String writer;
	private String translator;
	private String publisher;
	private Date publishedate;
	private Float price;
	private int isdelete;
	private Set orders = new HashSet(0);
	private Set stocks = new HashSet(0);
	private Set borrows = new HashSet(0);

	// Constructors

	/** default constructor */
	public BookInfo() {
	}

	/** minimal constructor */
	public BookInfo(String bookname) {
		this.bookname = bookname;
	}

	/** full constructor */
	public BookInfo(BookType bookType, String bookname, String writer,
			String translator, String publisher, Date publishedate,
			Float price, int isdelete, Set orders, Set stocks,
			Set borrows) {
		this.bookType = bookType;
		this.bookname = bookname;
		this.writer = writer;
		this.translator = translator;
		this.publisher = publisher;
		this.publishedate = publishedate;
		this.price = price;
		this.isdelete = isdelete;
		this.orders = orders;
		this.stocks = stocks;
		this.borrows = borrows;
	}

	// Property accessors

	public String getIsbn() {
		return this.isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public BookType getBookType() {
		return this.bookType;
	}

	public void setBookType(BookType bookType) {
		this.bookType = bookType;
	}

	public String getBookname() {
		return this.bookname;
	}

	public void setBookname(String bookname) {
		this.bookname = bookname;
	}

	public String getWriter() {
		return this.writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public String getTranslator() {
		return this.translator;
	}

	public void setTranslator(String translator) {
		this.translator = translator;
	}

	public String getPublisher() {
		return this.publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public Date getPublishedate() {
		return this.publishedate;
	}

	public void setPublishedate(Date publishedate) {
		this.publishedate = publishedate;
	}

	public Float getPrice() {
		return this.price;
	}

	public void setPrice(Float price) {
		this.price = price;
	}

	public int getIsdelete() {
		return this.isdelete;
	}

	public void setIsdelete(int isdelete) {
		this.isdelete = isdelete;
	}

	public Set getOrders() {
		return this.orders;
	}

	public void setOrders(Set orders) {
		this.orders = orders;
	}

	public Set getStocks() {
		return this.stocks;
	}

	public void setStocks(Set stocks) {
		this.stocks = stocks;
	}

	public Set getBorrows() {
		return this.borrows;
	}

	public void setBorrows(Set borrows) {
		this.borrows = borrows;
	}

}