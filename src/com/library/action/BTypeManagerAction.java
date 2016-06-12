package com.library.action;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.library.bean.PageBean;
import com.library.impl.BookTypeImpl;
import com.library.util.JUtils;
import com.opensymphony.xwork2.ActionSupport;

public class BTypeManagerAction extends ActionSupport{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Resource
	private BookTypeImpl bookTypeImpl;
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
        PageBean pageBean = bookTypeImpl.getPageBean(8, page);
        System.out.println("page="+page);
        HttpServletRequest request = ServletActionContext.getRequest();
        request.setAttribute("btypePageBean", pageBean);
	}
	
	public void delete() {
		if("delete".equals(method)) { //ɾ����Ա
        	if(JUtils.changeToNum(id)) {
        		System.out.println("id="+id);
        		System.out.println("method="+method);
        		int typeid = Integer.parseInt(id);
        		bookTypeImpl.deleteType(typeid);
        		pageInfo();
        	}
        }
	}
}
