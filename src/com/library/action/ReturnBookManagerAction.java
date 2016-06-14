package com.library.action;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.library.bean.PageBean;
import com.library.impl.BookInfoImpl;
import com.opensymphony.xwork2.ActionSupport;

public class ReturnBookManagerAction extends ActionSupport{

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
	 * ��ҳ��Ϣ
	 */
	private void pageInfo() {
		//��ʾÿҳ��ʾ5����¼��page��ʾ��ǰ��ҳ
		PageBean pageBean = bookInfoImpl.getPageBean2(8, page);
		System.out.println("page="+page);
		HttpServletRequest request = ServletActionContext.getRequest();
		request.setAttribute("bookPageBean", pageBean);
	}

	public void delete() {
		if("delete".equals(method)) { //ɾ���Ա
			System.out.println("id="+id);
			System.out.println("method="+method);
			bookInfoImpl.deleteBook(id);
			pageInfo();
		}
	}
}
