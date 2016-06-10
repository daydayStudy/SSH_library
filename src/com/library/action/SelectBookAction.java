package com.library.action;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.library.bean.PageBean;
import com.library.impl.BookInfoImpl;
import com.opensymphony.xwork2.ActionSupport;

public class SelectBookAction extends ActionSupport{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Resource
	private BookInfoImpl bookInfoImpl;
	
	private String bookname;
	private int page;
	private String method;
	private String id;

	public String getBookname() {
		return bookname;
	}

	public void setBookname(String bookname) {
		this.bookname = bookname;
	}
	
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
		if(bookname == null || "".equals(bookname.trim())) {
			pageInfo();
		}else {
			PageBean pageBean = bookInfoImpl.getPageBeanM(bookname,8, page);
			System.out.println("page="+page);
			HttpServletRequest request = ServletActionContext.getRequest();
			request.setAttribute("selectbookBean", pageBean);
			if(pageBean != null) {
				int len = pageBean.getList().size();
				request.setAttribute("listLen", len);
			}
			request.setAttribute("bookName", bookname);
		}

		return SUCCESS;
	}

	/**
	 * 分页信息
	 */
	private void pageInfo() {
		//表示每页显示5条记录，page表示当前网页
		PageBean pageBean = bookInfoImpl.getPageBeanR(8, page);
		System.out.println("page="+page);
		HttpServletRequest request = ServletActionContext.getRequest();
		request.setAttribute("selectbookBean", pageBean);
	}
}
