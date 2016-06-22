package com.library.bean;


public class ReturnBookBean {

	// b.isbn,bor.reader.name,b.bookname,bor.isback,bor.borrowdate,bor.backdate,s.amount
	private String borrowid;
	private String isbn;
	private String name;
	private String rederid;
	private String bookname;
	private int isback;
	private String borrowdate;
	private String backdate;
	private int amount;
	
	
	
	public String getBorrowid() {
		return borrowid;
	}
	public void setBorrowid(String borrowid) {
		this.borrowid = borrowid;
	}
	public String getRederid() {
		return rederid;
	}
	public void setRederid(String rederid) {
		this.rederid = rederid;
	}
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getBookname() {
		return bookname;
	}
	public void setBookname(String bookname) {
		this.bookname = bookname;
	}
	public int getIsback() {
		return isback;
	}
	public void setIsback(int isback) {
		this.isback = isback;
	}
	public String getBorrowdate() {
		return borrowdate;
	}
	public void setBorrowdate(String borrowdate) {
		this.borrowdate = borrowdate;
	}
	
	public String getBackdate() {
		return backdate;
	}
	public void setBackdate(String backdate) {
		this.backdate = backdate;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	
}
