package com.library.bean;

import java.util.HashSet;
import java.util.Set;

/**
 * BookType entity. @author MyEclipse Persistence Tools
 */

public class BookType implements java.io.Serializable {

	// Fields

	private int typeid;
	private String typename;
	private Float finemoney;
	private int days;
	private int isdelete;
	private Set bookInfos = new HashSet(0);

	// Constructors

	/** default constructor */
	public BookType() {
	}

	/** minimal constructor */
	public BookType(String typename, Float finemoney, int days) {
		this.typename = typename;
		this.finemoney = finemoney;
		this.days = days;
	}

	/** full constructor */
	public BookType(String typename, Float finemoney, int days,
			int isdelete, Set bookInfos) {
		this.typename = typename;
		this.finemoney = finemoney;
		this.days = days;
		this.isdelete = isdelete;
		this.bookInfos = bookInfos;
	}

	// Property accessors

	public int getTypeid() {
		return this.typeid;
	}

	public void setTypeid(int typeid) {
		this.typeid = typeid;
	}

	public String getTypename() {
		return this.typename;
	}

	public void setTypename(String typename) {
		this.typename = typename;
	}

	public Float getFinemoney() {
		return this.finemoney;
	}

	public void setFinemoney(Float finemoney) {
		this.finemoney = finemoney;
	}

	public int getDays() {
		return this.days;
	}

	public void setDays(int days) {
		this.days = days;
	}

	public int getIsdelete() {
		return this.isdelete;
	}

	public void setIsdelete(int isdelete) {
		this.isdelete = isdelete;
	}

	public Set getBookInfos() {
		return this.bookInfos;
	}

	public void setBookInfos(Set bookInfos) {
		this.bookInfos = bookInfos;
	}

}