package com.library.action;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.library.bean.PageBean;
import com.library.impl.BookInfoImpl;
import com.opensymphony.xwork2.ActionSupport;

public class BookManagerAction extends ActionSupport{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Resource
	private BookInfoImpl bookInfoImpl;
	private int page;
	private String method;
	private String id;

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
		delete();

		return SUCCESS;
	}

	/**
	 * 分页信息
	 */
	private void pageInfo() {
		//表示每页显示5条记录，page表示当前网页
		PageBean pageBean = bookInfoImpl.getPageBean(8, page);
		System.out.println("page="+page);
		HttpServletRequest request = ServletActionContext.getRequest();
		request.setAttribute("bookPageBean", pageBean);
	}

	public void delete() {
		if("delete".equals(method)) { //删除会员
			System.out.println("id="+id);
			System.out.println("method="+method);
			bookInfoImpl.deleteBook(id);
			pageInfo();
		}
	}
}
