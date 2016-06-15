package com.library.action;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.library.bean.PageBean;
import com.library.impl.BorrowImpl;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class BorrowRecordAction extends ActionSupport {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int page;
	private String method;
	private String id;
	private BorrowImpl borrowImpl = new BorrowImpl();
	
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public String getMethod() {
		return method;
	}
	public void setMethod(String method) {
		this.method = method;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
	@Override
	public String execute() throws Exception {
		pageInfo();
		return SUCCESS;
	}

	private void pageInfo() {
		ActionContext context=ActionContext.getContext();
		//Õ˘session¿Ô∑≈
		String idString = (String) context.getSession().get("loginName");
		System.out.println("id="+idString);
		int id = Integer.parseInt(idString);
		
		PageBean pageBean = borrowImpl.getPageBean(id,11, page);
		System.out.println("page="+page);
		HttpServletRequest request = ServletActionContext.getRequest();
		request.setAttribute("recordPageBean", pageBean);
	}
}
