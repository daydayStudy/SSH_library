package com.library.action;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class OrderAction extends ActionSupport {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String isbn;
	private String bookname;
	private String typename;

	public String getBookname() {
		return bookname;
	}

	public void setBookname(String bookname) {
		this.bookname = bookname;
	}

	public String getTypename() {
		return typename;
	}

	public void setTypename(String typename) {
		this.typename = typename;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	@Override
	public String execute() throws Exception {
		ActionContext context=ActionContext.getContext();
		String readerId = context.getSession().get("loginName").toString();
		HttpServletRequest request = ServletActionContext.getRequest();
		request.setCharacterEncoding("utf-8");
		request.setAttribute("isbn", isbn);
		request.setAttribute("readerid", readerId);
		request.setAttribute("bookname", bookname);
		request.setAttribute("typename", typename);

		return SUCCESS;
	}

}
