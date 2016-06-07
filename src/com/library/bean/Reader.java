package com.library.bean;

import java.util.HashSet;
import java.util.Set;

/**
 * Reader entity. @author MyEclipse Persistence Tools
 */

public class Reader implements java.io.Serializable {

	// Fields

	private int readerid;
	private String name;
	private String pwd;
	private int age;
	private String sex;
	private String tel;
	private String email;
	private int isdelete;
	private Set tickets = new HashSet(0);
	private Set orders = new HashSet(0);
	private Set borrows = new HashSet(0);

	// Constructors

	/** default constructor */
	public Reader() {
	}

	/** minimal constructor */
	public Reader(String name, String pwd) {
		this.name = name;
		this.pwd = pwd;
	}

	/** full constructor */
	public Reader(String name, String pwd, int age, String sex,
			String tel, String email, int isdelete, Set tickets,
			Set orders, Set borrows) {
		this.name = name;
		this.pwd = pwd;
		this.age = age;
		this.sex = sex;
		this.tel = tel;
		this.email = email;
		this.isdelete = isdelete;
		this.tickets = tickets;
		this.orders = orders;
		this.borrows = borrows;
	}

	// Property accessors

	public int getReaderid() {
		return this.readerid;
	}

	public void setReaderid(int readerid) {
		this.readerid = readerid;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPwd() {
		return this.pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public int getAge() {
		return this.age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getSex() {
		return this.sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getTel() {
		return this.tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getIsdelete() {
		return this.isdelete;
	}

	public void setIsdelete(int isdelete) {
		this.isdelete = isdelete;
	}

	public Set getTickets() {
		return this.tickets;
	}

	public void setTickets(Set tickets) {
		this.tickets = tickets;
	}

	public Set getOrders() {
		return this.orders;
	}

	public void setOrders(Set orders) {
		this.orders = orders;
	}

	public Set getBorrows() {
		return this.borrows;
	}

	public void setBorrows(Set borrows) {
		this.borrows = borrows;
	}

}