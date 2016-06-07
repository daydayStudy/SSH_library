package com.library.bean;

import java.util.Date;

/**
 * Ticket entity. @author MyEclipse Persistence Tools
 */

public class Ticket implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int ticketid;
	private Reader reader;
	private Date ticketdate;
	private Float money;

	// Constructors

	/** default constructor */
	public Ticket() {
	}

	/** full constructor */
	public Ticket(Reader reader, Date ticketdate, Float money) {
		this.reader = reader;
		this.ticketdate = ticketdate;
		this.money = money;
	}

	// Property accessors

	public int getTicketid() {
		return this.ticketid;
	}

	public void setTicketid(int ticketid) {
		this.ticketid = ticketid;
	}

	public Reader getReader() {
		return this.reader;
	}

	public void setReader(Reader reader) {
		this.reader = reader;
	}

	public Date getTicketdate() {
		return this.ticketdate;
	}

	public void setTicketdate(Date ticketdate) {
		this.ticketdate = ticketdate;
	}

	public Float getMoney() {
		return this.money;
	}

	public void setMoney(Float money) {
		this.money = money;
	}

}