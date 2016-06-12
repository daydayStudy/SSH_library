package com.library.bean;


/**
 * Admin entity. @author MyEclipse Persistence Tools
 */

public class Admin implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int admindid;
	private String name;
	private Integer age;
	private String sex;
	private String tel;
	private String email;
	private String pwd;

	// Constructors

	/** default constructor */
	public Admin() {
	}

	/** minimal constructor */
	public Admin(int admindid, String name, String pwd) {
		this.admindid = admindid;
		this.name = name;
		this.pwd = pwd;
	}

	/** full constructor */
	public Admin(int admindid, String name, Integer age, String sex,
			String tel, String email, String pwd) {
		this.admindid = admindid;
		this.name = name;
		this.age = age;
		this.sex = sex;
		this.tel = tel;
		this.email = email;
		this.pwd = pwd;
	}

	// Property accessors

	public int getAdmindid() {
		return this.admindid;
	}

	public void setAdmindid(int admindid) {
		this.admindid = admindid;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return this.age;
	}

	public void setAge(Integer age) {
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

	public String getPwd() {
		return this.pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

}